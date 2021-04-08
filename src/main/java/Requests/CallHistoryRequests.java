package Requests;

import ApplicationManager.MainApplication;
import jsons.calls.JsonCalls;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;

public class CallHistoryRequests extends MainApplication {

    RegisterData data;

    public CallHistoryRequests(RegisterData data) {
        this.data = data;
    }


    public JsonObject callsRecent(){
        String json = getJson("src/main/java/jsons/calls/recent.json");
        String url = "/calls/recent";
        return post_response(json,url,data);
    }

    public JsonObject getRecordLink(String sid){
        String json = new JsonCalls().getRecord(sid);
        String url = "/calls/getRecordLink";
        return post_response(json,url,data);
    }

    public JsonObject checkRecord(String url){
        String go_href_record_ling = RestAssured.get(url).asString();
        System.out.println("\nResponse go_href_record_ling:\n" + go_href_record_ling);
        return JsonParser.parseString(go_href_record_ling).getAsJsonObject();
    }

    public JsonObject callsHistory(String number){
        String json = new JsonCalls().callsHistory(number);
        String url = "/calls/history";
        return post_response(json,url,data);
    }

    public JsonObject callsNotifyAnswered(String callId, String contextId){
        String json = new JsonCalls().callsNotifyAnswered(callId,contextId);
        String url = "/calls/notifyAnswered";
        return post_response(json,url,data);
    }

    public JsonObject callsNotifyStarted(String contextId){
        String json = new JsonCalls().callsNotifyStarted(contextId);
        String url = "/calls/notifyStarted ";
        return post_response(json,url,data);
    }

    public JsonObject callsSearch(String query){
        String json = new JsonCalls().callsSearch(query);
        String url = "/calls/search";
        return post_response(json,url,data);
    }

    public JsonObject callsSync(){
        String json = new JsonCalls().callsSync();
        String url = "/calls/sync";
        return post_response(json,url,data);
    }

    public JsonObject callsGet(){
        String json = new JsonCalls().callsGet();
        String url = "/calls/get";
        return post_response(json,url,data);
    }

    public JsonObject callsRemove(String sid){
        String json = new JsonCalls().callsRemove(sid);
        String url = "/calls/remove";
        return post_response(json,url,data);
    }

    public JsonObject callsRemoveAll(String sid){
        String json = new JsonCalls().callsRemoveAll(sid);
        String url = "/calls/removeAll";
        return post_response(json,url,data);
    }

    public JsonObject callsResetMissedCount(String sid){
        String json = new JsonCalls().callsResetMissedCount(sid);
        String url = "/calls/resetMissedCount";
        return post_response(json,url,data);
    }

    public JsonObject callsSetOutgoingLine(String account, String outgoingline){
        String json = new JsonCalls().callsSetOutgoingLine(account,outgoingline);
        String url = "/calls/setOutgoingLine";
        return post_response(json,url,data);
    }

    public JsonObject callsNotesSave(String sid){
        String json = new JsonCalls().callsNotesSave(sid);
        String url = "/calls/notes/save";
        return post_response(json,url,data);
    }
}
