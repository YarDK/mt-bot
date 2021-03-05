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

    public JsonObject method(String json, String url){
        System.out.println("\nJson for "+url+":\n" + json);

        String post_request = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json)
                .post(data.getUrl_4talk() + url).asString();
        System.out.println("\nResponse for "+url+":\n" + post_request);
        return JsonParser.parseString(post_request).getAsJsonObject();
    }

    public JsonObject callsRecent(){
        String json = getJson("src/main/java/jsons/calls/recent.json");
        String url = "/calls/recent";
        return method(json,url);
    }

    public JsonObject getRecordLink(String sid){
        String json = new JsonCalls().getRecord(sid);
        String url = "/calls/getRecordLink";
        return method(json,url);
    }

    public JsonObject checkRecord(String url){
        String go_href_record_ling = RestAssured.get(url).asString();
        System.out.println("\nResponse go_href_record_ling:\n" + go_href_record_ling);
        return JsonParser.parseString(go_href_record_ling).getAsJsonObject();
    }

    public JsonObject callsHistory(String number){
        String json = new JsonCalls().callsHistory(number);
        String url = "/calls/history";
        return method(json,url);
    }

    public JsonObject callsHistory_ref(String number){
        String json = new JsonCalls().callsHistory(number);
        String url = "/calls/history";
        return method(json,url);
    }

    public JsonObject callsNotifyAnswered(String callId, String contextId){
        String json = new JsonCalls().callsNotifyAnswered(callId,contextId);
        String url = "/calls/notifyAnswered";
        return method(json,url);
    }

    public JsonObject callsNotifyStarted(String contextId){
        String json = new JsonCalls().callsNotifyStarted(contextId);
        String url = "/calls/notifyStarted ";
        return method(json,url);
    }

    public JsonObject callsSearch(String query){
        String json = new JsonCalls().callsSearch(query);
        String url = "/calls/search";
        return method(json,url);
    }

    public JsonObject callsSync(){
        String json = new JsonCalls().callsSync();
        String url = "/calls/sync";
        return method(json,url);
    }

    public JsonObject callsGet(){
        String json = new JsonCalls().callsGet();
        String url = "/calls/get";
        return method(json,url);
    }

    public JsonObject callsRemove(String sid){
        String json = new JsonCalls().callsRemove(sid);
        String url = "/calls/remove";
        return method(json,url);
    }

    public JsonObject callsRemoveAll(String sid){
        String json = new JsonCalls().callsRemoveAll(sid);
        String url = "/calls/removeAll";
        return method(json,url);
    }

    public JsonObject callsResetMissedCount(String sid){
        String json = new JsonCalls().callsResetMissedCount(sid);
        String url = "/calls/resetMissedCount";
        return method(json,url);
    }

    public JsonObject callsSetOutgoingLine(String account, String outgoingline){
        String json = new JsonCalls().callsSetOutgoingLine(account,outgoingline);
        String url = "/calls/setOutgoingLine";
        return method(json,url);
    }

    public JsonObject callsNotesSave(String sid){
        String json = new JsonCalls().callsNotesSave(sid);
        String url = "/calls/notes/save";
        return method(json,url);
    }



}
