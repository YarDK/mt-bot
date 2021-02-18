package Requests;

import ApplicationManager.MainApplication;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import jsons.autosecretary.JsonAutosecretary;

public class Autosecretary extends MainApplication {

    RegisterData data;

    public Autosecretary(RegisterData data) {
        this.data = data;
    }

    private final static JsonAutosecretary json_autosecretary = new JsonAutosecretary();


    public JsonObject add(){
        String json_autosecretary_add = getJson("src/main/java/jsons/autosecretary/add.json");
        System.out.println("\njson_autosecretary_add:\n" + json_autosecretary_add);
        String url = data.getUrl_4talk() + "/autosecretary/add";
        String autosecretary_add = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_autosecretary_add)
                .post(url).asString();

        System.out.println("\nResponse autosecretary_add:\n" + autosecretary_add);
        return JsonParser.parseString(autosecretary_add).getAsJsonObject();
    }

    public JsonObject get(){
        String json_autosecretary_get = json_autosecretary.get();
        System.out.println("\njson_autosecretary_get:\n" + json_autosecretary_get);
        String url = data.getUrl_4talk() + "/autosecretary/get";
        String autosecretary_get = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_autosecretary_get)
                .post(url).asString();

        System.out.println("\nResponse autosecretary_get:\n" + autosecretary_get);
        return JsonParser.parseString(autosecretary_get).getAsJsonObject();
    }

    public JsonObject update(int rule_id){
        String json_autosecretary_update = json_autosecretary.update(rule_id);
        System.out.println("\njson_autosecretary_update:\n" + json_autosecretary_update);
        String url = data.getUrl_4talk() + "/autosecretary/update";
        String autosecretary_update = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_autosecretary_update)
                .post(url).asString();

        System.out.println("\nResponse autosecretary_update:\n" + autosecretary_update);
        return JsonParser.parseString(autosecretary_update).getAsJsonObject();
    }


    public JsonObject del(int rule_id){
        String json_autosecretary_del = json_autosecretary.del(rule_id);
        System.out.println("\njson_autosecretary_del:\n" + json_autosecretary_del);
        String url = data.getUrl_4talk() + "/autosecretary/del";
        String autosecretary_del = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_autosecretary_del)
                .post(url).asString();

        System.out.println("\nResponse autosecretary_del:\n" + autosecretary_del);
        return JsonParser.parseString(autosecretary_del).getAsJsonObject();
    }


}
