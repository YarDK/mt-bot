package Requests;

import ApplicationManager.MainApplication;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class Autosecretary extends MainApplication {

    RegisterData data;

    public Autosecretary(RegisterData data) {
        this.data = data;
    }


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
}
