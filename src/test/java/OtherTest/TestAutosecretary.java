package OtherTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestAutosecretary {

    @Test
    public void testCreateContactInABC() {
        getJsonTest();
    }

    @Test
    public void testJsonResponse(){
        System.out.println(jsonAutosecretaryAdd());
    }

    private void getJsonTest() {
        // Входные параметры
        // Нужно сделать модель и хранить данные в ней
        String username = "testserver@talk.mangosip.ru";
        String password = "123456aB";
        String device_id = "123456789012345678901234567890ac"; // Любое 16-битное число общей длиной 32 символа
        String device_name = "TestDevice";
        String app = "MT.Mobile";
        String os = "Apache_win10";

        String url_register = "https://chatapi-temp.mango-office.ru/register";
        String url_authvpbx = "http://auth-prerelease-ru.by.mgo.su/auth/vpbx";
        String url_unregister = "https://chatapi-temp.mango-office.ru/removeDevice";

        String url_autosecretary_add = "https://chatapi-temp.mango-office.ru/autosecretary/add";

        // Автотизация на сервере и получение токена

        String auth_vpbx = RestAssured.given()
                .parameter("username",username)
                .parameter("password",password)
                .parameter("deviceId",device_id)
                .parameter("app",app)
                .post(url_authvpbx).asString();
        System.out.println("Request auth_vpbx:\n" + auth_vpbx);

        JsonObject json_auth_token = JsonParser.parseString(auth_vpbx).getAsJsonObject();
        String auth_token = json_auth_token.getAsJsonObject().get("auth_token").getAsString();
        System.out.println("\nAuth_token:\n" + auth_token);

        // Регистрация учетки и получение хеша авторизации
        String register = RestAssured.given()
                .auth()
                .preemptive()
                .basic(username, password)
                .parameter("deviceId", device_id)
                .parameter("deviceName", device_name)
                .parameter("os", os)
                .post(url_register).asString();
        System.out.println("\nRequest register:\n" + register);

        JsonObject json_account_hash = JsonParser.parseString(register).getAsJsonObject();
        String account = json_account_hash.getAsJsonObject().get("data").getAsJsonObject().get("account").getAsString();
        String hash = json_account_hash.getAsJsonObject().get("data").getAsJsonObject().get("hash").getAsString();

        // ВОТ ТУТ ДЕЛАЕМ:
        String json_autosecretary_add = jsonAutosecretaryAdd();
        System.out.println("\nJson json_autosecretary_add:\n" + json_autosecretary_add);

        try {
            String autosecretary_add = RestAssured.given()
                    .auth()
                    .preemptive()
                    .basic(account, hash)
                    .contentType(ContentType.JSON)
                    .body(json_autosecretary_add)
                    .post(url_autosecretary_add).asString();
            System.out.println("\nRequest autosecretary_add:\n" + autosecretary_add);
        } catch (Exception e){
            e.printStackTrace();
        }

        // Разлогиниваемя в приложении
        String unregister = RestAssured.given()
                .auth()
                .preemptive()
                .basic(account, hash)
                .parameter("deviceId", device_id)
                .post(url_unregister).asString();
        System.out.println("\nRequest unregister:\n" + unregister);

    }

    // Построение json
    public String jsonAutosecretaryAdd(){
        /*
{
  "product_id": 300024327,
  "author_id": 400085468,
  "abonent_id": 400032147,
  "rule": {
    "name": "Использовать индивидуальный автосекретарь",
    "active": true,
    "direction": [
      "incoming",
      "internal"
    ],
    "wait_time": 15,
    "melody_id": 53486,
    "actions": [
      {
        "action": "end_call",
        "param": ""
      },
      {
        "action": "voice_mail",
        "param": "test@example.com"
      },
      {
        "action": "redirect_group",
        "param": 10075532
      },
      {
        "action": "redirect_member",
        "param": 40035647
      },
      {
        "action": "redirect_ext_number",
        "param": 74957001122
      }
    ]
  }
}
         */

        int product_id = 400062183;
        int abonent_id = 402175321;
        JsonObject rule_into = new JsonObject();
        rule_into.addProperty("name", "Test_rule_yar_1");
        rule_into.addProperty("active", false);
        JsonArray direction_arr = new JsonArray();
        direction_arr.add("incoming");
        direction_arr.add("internal");
        rule_into.add("direction", direction_arr);
        rule_into.addProperty("wait_time", 20);

        //JsonObject actions_into = new JsonObject();
        JsonObject call_end = new JsonObject();
        call_end.addProperty("action", "end_call");
        call_end.addProperty("param", "");
        JsonObject voice_email = new JsonObject();
        voice_email.addProperty("action", "voice_mail");
        voice_email.addProperty("param", "email@email.com");
        JsonArray actions_arr = new JsonArray();
        actions_arr.add(call_end);
        actions_arr.add(voice_email);
        rule_into.add("actions", actions_arr);

        JsonObject main_json = new JsonObject();
        main_json.addProperty("product_id", product_id);
        main_json.addProperty("abonent_id", abonent_id);
        main_json.add("rule", rule_into);

        return main_json.toString();
    }


}
