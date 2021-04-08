package Requests;

import ApplicationManager.MainApplication;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import jsons.stats.JsonStats;
import org.testng.Assert;

public class SessionsRequests extends MainApplication {
    public RegisterData data;

    public SessionsRequests(RegisterData data) {
        this.data = data;
    }

    // Автотизация на сервере и получение токена
    public void authorisation() {
        String url = data.getUrl_auth() + "/auth/vpbx";
        String auth_vpbx = RestAssured.given()
                .parameter("username", data.getUsername())
                .parameter("password", data.getPassword())
                .parameter("deviceId", data.getDevice_id())
                .parameter("app", data.getApplication())
                .post(url).asString();
        System.out.println("Response auth_vpbx:\n" + auth_vpbx);
        JsonObject json_auth_token = JsonParser.parseString(auth_vpbx).getAsJsonObject();
        Assert.assertEquals(
                json_auth_token.getAsJsonObject().get("result").getAsInt(),
                1000,
                "Authorisation failed, result not 1000");

        data.withAuth_token(json_auth_token.getAsJsonObject().get("auth_token").getAsString());
        System.out.println("\nAuth_token:\n" + data.getAuth_token());
    }

    // Получение Credentials (пара логин и пароль)
    public void credentials(){
        String url = String.format("%s/credentials/sip?auth_token=%s", data.getUrl_auth(), data.getAuth_token());
        String credentials = RestAssured.get(url).asString();
        System.out.println("\nResponse credentials:\n" + credentials);
        JsonObject json_credentials = JsonParser.parseString(credentials).getAsJsonObject();
        Assert.assertEquals(
                json_credentials.getAsJsonObject().get("result").getAsInt(),
                1000,
                "Credentials failed, result not 1000");

        data.withCredentials(json_credentials.getAsJsonObject().get("data").getAsString());

    }

    public void startSession(){
        String url = data.getUrl_4talk() + "/startSession";
        String start_session = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .parameter("status", data.getDefault_status())
                .parameter("textStatus", data.getTextStatus())
                .parameter("model", data.getModel())
                .parameter("os", data.getOs())
                .post(url).asString();
        System.out.println("\nResponse start_session:\n" + start_session);

        JsonObject response_start_session = JsonParser.parseString(start_session).getAsJsonObject();
        Assert.assertEquals(
                response_start_session.getAsJsonObject().get("statusCode").getAsInt(),
                200,
                "Start session failed, result not 200");

        data.withAbonent_id(response_start_session
                .getAsJsonObject("data")
                .getAsJsonObject("user")
                .getAsJsonObject("vcard")
                .getAsJsonObject("mangoExtra")
                .getAsJsonObject("general")
                .get("abonent_id").getAsString());

        data.withProduct_id (response_start_session
                .getAsJsonObject("data")
                .getAsJsonObject("user")
                .get("productId").getAsString());

        data.withLast_seen(response_start_session
                .getAsJsonObject("data")
                .getAsJsonObject("user")
                .getAsJsonObject("status")
                .get("lastSeen").getAsString());

        // По идеи не работает для карточки, где несколько номеров
        try {
            JsonObject numbers = response_start_session
                    .getAsJsonObject("data")
                    .getAsJsonObject("user")
                    .getAsJsonObject("vcard")
                    .getAsJsonObject("mangoExtra")
                    .getAsJsonObject("telephony")
                    .getAsJsonArray("numbers").get(0).getAsJsonObject();

            data.withNumber_id(numbers.get("number_id").getAsLong());

            data.withNumber(numbers.get("number").getAsString());

            data.withProtocol(numbers.get("protocol").getAsString());

        } catch (IndexOutOfBoundsException e){
            System.out.println("!!! WARNING:");
            e.printStackTrace();
        }

    }

    // Регистрация учетки и получение хеша авторизации
    public void registration() {
        String url = data.getUrl_4talk() + "/register";
        String register = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getUsername(), data.getPassword())
                .parameter("deviceId", data.getDevice_id())
                .parameter("deviceName", data.getDevice_name())
                .parameter("os", data.getOs())
                .post(url).asString();
        System.out.println("\nResponse register:\n" + register);

        JsonObject json_account_hash = JsonParser.parseString(register).getAsJsonObject();
        Assert.assertEquals(
                json_account_hash.getAsJsonObject().get("statusCode").getAsInt(),
                200,
                "Registration failed, result not 200");

        data.withAccount(json_account_hash.getAsJsonObject().get("data").getAsJsonObject().get("account").getAsString());
        data.withHash(json_account_hash.getAsJsonObject().get("data").getAsJsonObject().get("hash").getAsString());
    }

    // Разрегистрация учетки
    public void unregister() {
        String url = data.getUrl_4talk() + "/removeDevice";
        String unregister = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .parameter("deviceId", data.getDevice_id())
                .post(url).asString();
        System.out.println("\nResponse unregister:\n" + unregister);

        JsonObject json_account_hash = JsonParser.parseString(unregister).getAsJsonObject();
        Assert.assertEquals(
                json_account_hash.getAsJsonObject().get("statusCode").getAsInt(),
                200,
                "Registration failed, result not 200");
    }

    public JsonObject statsGetData(){
        String url = "/stats/getData";
        String json = new JsonStats().getData();
        return post_response(json, url, data);
    }

    public JsonObject statsGetLaunches(){
        String url = "/stats/getLaunches";
        String json = new JsonStats().getLaunches();
        return post_response(json, url, data);
    }
}
