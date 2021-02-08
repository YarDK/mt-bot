package Requests;

import ApplicationManager.MainApplication;
import jsons.calls.JsonCalls;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class CallHistoryRequests extends MainApplication {

    RegisterData data;

    public CallHistoryRequests(RegisterData data) {
        this.data = data;
    }

    public JsonObject callsRecent(){
        String json_calls_recent = getJson("src/main/java/jsons/calls/recent.json");
        System.out.println("\njson_calls_recent:\n" + json_calls_recent);
        String url = data.getUrl_4talk() + "/calls/recent";
        String calls_recent = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_calls_recent)
                .post(url).asString();
        System.out.println("\nResponse calls_recent:\n" + calls_recent);
        return JsonParser.parseString(calls_recent).getAsJsonObject();
    }

    public JsonObject getRecordLink(String sid){
        String json_calls_get_record = new JsonCalls().getRecord(sid);
        System.out.println("\njson_calls_get_record:\n" + json_calls_get_record);
        String url = data.getUrl_4talk() + "/calls/getRecordLink";
        String calls_get_record = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_calls_get_record)
                .post(url).asString();
        System.out.println("\nResponse calls_get_record:\n" + calls_get_record);
        return JsonParser.parseString(calls_get_record).getAsJsonObject();
    }

    public JsonObject checkRecord(String url){
        String go_href_record_ling = RestAssured.get(url).asString();
        System.out.println("\nResponse go_href_record_ling:\n" + go_href_record_ling);
        return JsonParser.parseString(go_href_record_ling).getAsJsonObject();
    }
}
