package OtherTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import com.jayway.restassured.RestAssured;

import com.jayway.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestContactAddProd {

    @Test
    public void testCreateContactInABC() {
        getJsonTest();
    }

    private void getJsonTest() {
        // Входные параметры
        // Нужно сделать модель и хранить данные в ней
        String username = "testserver@talk.mangosip.ru";
        String password = "123456aB";
        String url_register = "https://chatapi.mango-office.ru/register";
        String device_id = "123456789012345678901234567890ac"; // Любое 16-битное число общей длиной 32 символа
        String device_name = "TestDevice";
        String app = "MT.Mobile";
        String os = "Apache_win10";

        // Автотизация на сервере и получение токена
        String url_authvpbx = "https://auth.mango-office.ru/auth/vpbx";
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

        // Создаем конгтакт в адресной книге компании с использованием построенного json
        String json_contact_add = jsonContactAdd();
        System.out.println("\nJson contact add:\n" + json_contact_add);

        String url_contact_add = "https://ab.mango-office.ru/contacts/add";
        String contact_add = RestAssured.given()
                //.auth().oauth2(auth_token, OAuthSignature.HEADER)
                .header("X-AUTH-TOKEN", auth_token)
                .contentType(ContentType.JSON)
                .body(json_contact_add)
                .post(url_contact_add).asString();
        System.out.println("\nRequest contact add:\n" + contact_add);

        // Разлогиниваемя в приложении
        String url_unregister = "https://chatapi.mango-office.ru/removeDevice";
        String unregister = RestAssured.given()
                .auth()
                .preemptive()
                .basic(account, hash)
                .parameter("deviceId", device_id)
                .post(url_unregister).asString();
        System.out.println("\nRequest unregister:\n" + unregister);

    }

    // Построение json
    public String jsonContactAdd(){
        // {
        //   "source_id":{
        //      "index":0,
        //      "product_id":400062183,
        //      "type":"vpbx"
        //   },
        //   "data":[
        //      {
        //         "source_id":{
        //            "index":0,
        //            "product_id":400062183,
        //            "type":"vpbx"
        //         },
        //         "type":0,
        //         "name":"Contact Authotest",
        //         "birthday":"",
        //         "avatar":"",
        //         "org":null,
        //         "department":"",
        //         "office":"",
        //         "site":"",
        //         "comment":"",
        //         "phones":[
        //            {
        //               "phone":"85555555555",
        //               "type":4,
        //               "comment":"",
        //               "ext":"",
        //               "is_default":false
        //            }
        //         ],
        //         "emails":[
        //
        //         ]
        //      }
        //   ]
        //}

        JsonObject source_id_into = new JsonObject();
        source_id_into.addProperty("index",0);
        source_id_into.addProperty("product_id",400062183);
        source_id_into.addProperty("type","vpbx");

        JsonObject data_into = new JsonObject();
        data_into.add("source_id", source_id_into);
        data_into.addProperty("type", 0);
        data_into.addProperty("name", "Contact Authotest2");
        data_into.addProperty("birthday","");
        data_into.addProperty("avatar","");
        data_into.add("org",null);
        data_into.addProperty("department","");
        data_into.addProperty("office","");
        data_into.addProperty("site","");
        data_into.addProperty("comment","");

        JsonObject phones_into = new JsonObject();
        phones_into.addProperty("phone", "85555555533");
        phones_into.addProperty("type", 4);
        phones_into.addProperty("comment", "");
        phones_into.addProperty("ext", "");
        phones_into.addProperty("is_default", false);

        JsonArray phone_arr = new JsonArray();
        phone_arr.add(phones_into);
        data_into.add("phones", phone_arr);

        // Так как массив пустой, то и передвать нечего
        //JsonObject emails_into = new JsonObject();
        JsonArray emails_arr = new JsonArray();
        //emails_arr.add(emails_into);
        data_into.add("emails", emails_arr);

        JsonObject main_json = new JsonObject();
        main_json.add("source_id", source_id_into);

        JsonArray data_arr = new JsonArray();
        data_arr.add(data_into);
        main_json.add("data", data_arr);

        return main_json.toString();
    }

    @Test
    public void testJSON() {
        // JSON libraries
        // Пример использования бибилиотеки json
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams_level_3 = new JSONObject();
        JSONObject requestParams_level_4 = new JSONObject();

        requestParams_level_4.put("atribut3", "parametr");
        requestParams_level_3.put("atribut2", requestParams_level_4);
        requestParams.put("atribut1", new JSONArray().put(requestParams_level_3));
        System.out.println(requestParams);
        System.out.println(requestParams.getJSONArray("atribut1"));
        System.out.println(requestParams.getJSONArray("atribut1").getJSONObject(0).getJSONObject("atribut2"));
        System.out.println(requestParams.getJSONArray("atribut1").getJSONObject(0).getJSONObject("atribut2").getString("atribut3"));

    }

    @Test
    public void testGSON() {

        // GSON libraries
        // Пример использования бибилиотеки gson
        // Данная библиотека лучше всего работает по многим характеристикам
        JsonObject params = new JsonObject();
        JsonObject params_level_2 = new JsonObject();
        JsonObject params_level_3 = new JsonObject();
        JsonArray params_array = new JsonArray();

        params_level_3.addProperty("atribut3", "parametr");
        params_level_2.add("atribut2", params_level_3);
        params_array.add(params_level_2);
        params.add("atribut1", params_array);

        System.out.println(params);
        System.out.println(params.getAsJsonArray("atribut1"));
        System.out.println(params.getAsJsonArray("atribut1").get(0).getAsJsonObject().get("atribut2"));
        System.out.println(params.getAsJsonArray("atribut1").get(0).getAsJsonObject().get("atribut2").getAsJsonObject().get("atribut3").getAsString());

    }

    @Test
    public void testJsonCreateContactAdd(){
        // {
        //   "source_id":{
        //      "index":0,
        //      "product_id":400062183,
        //      "type":"vpbx"
        //   },
        //   "data":[
        //      {
        //         "source_id":{
        //            "index":0,
        //            "product_id":400062183,
        //            "type":"vpbx"
        //         },
        //         "type":0,
        //         "name":"Contact Authotest",
        //         "birthday":"",
        //         "avatar":"",
        //         "org":null,
        //         "department":"",
        //         "office":"",
        //         "site":"",
        //         "comment":"",
        //         "phones":[
        //            {
        //               "phone":"85555555555",
        //               "type":4,
        //               "comment":"",
        //               "ext":"",
        //               "is_default":false
        //            }
        //         ],
        //         "emails":[
        //
        //         ]
        //      }
        //   ]
        //}

        JsonObject source_id_into = new JsonObject();
        source_id_into.addProperty("index",0);
        source_id_into.addProperty("product_id",400062183);
        source_id_into.addProperty("type","vpbx");

        JsonObject data_into = new JsonObject();
        data_into.add("source_id", source_id_into);
        data_into.addProperty("type", 0);
        data_into.addProperty("name", "Contact Authotest");
        data_into.addProperty("birthday","");
        data_into.addProperty("avatar","");
        data_into.add("org",null);
        data_into.addProperty("department","");
        data_into.addProperty("office","");
        data_into.addProperty("site","");
        data_into.addProperty("comment","");

        JsonObject phones_into = new JsonObject();
        phones_into.addProperty("phone", "85555555555");
        phones_into.addProperty("type", 4);
        phones_into.addProperty("comment", "");
        phones_into.addProperty("ext", "");
        phones_into.addProperty("is_default", false);

        JsonArray phone_arr = new JsonArray();
        phone_arr.add(phones_into);
        data_into.add("phones", phone_arr);

        // Так как массив пустой, то и передвать нечего
        //JsonObject emails_into = new JsonObject();
        JsonArray emails_arr = new JsonArray();
        //emails_arr.add(emails_into);
        data_into.add("emails", emails_arr);

        JsonObject main_json = new JsonObject();
        main_json.add("source_id", source_id_into);

        JsonArray data_arr = new JsonArray();
        data_arr.add(data_into);
        main_json.add("data", data_arr);

        System.out.println(main_json);
    }


    @Test
    public void testAuth(){

        String url_authvpbx = "https://auth.mango-office.ru/auth/vpbx";

        String auth_vpbx = RestAssured.given()
                .parameter("username","testserver@talk.mangosip.ru")
                .parameter("password","123456aB")
                .parameter("deviceId","123456789012345678901234567890ac")
                .parameter("app","MT.Mobile")
                .post(url_authvpbx).asString();
        System.out.println(auth_vpbx);

        JsonObject jsonObject = JsonParser.parseString(auth_vpbx).getAsJsonObject();
        String auth_token = jsonObject.getAsJsonObject().get("auth_token").getAsString();
        System.out.println(auth_token);


    }


    // For example
    /*
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender"); // Cast
        requestParams.put("LastName", "Singh");
        requestParams.put("UserName", "sdimpleuser2dd2011");
        requestParams.put("Password", "password1");

        requestParams.put("Email", "sample2ee26d9@gmail.com");
        request.body(requestParams);
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, "201");
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");
    }
    */

}
