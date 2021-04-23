package Requests;

import ApplicationManager.MainApplication;
import jsons.settings.JsonSaveSettings;
import jsons.settings.JsonSettings;
import jsons.status.JsonStatus;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class ProfileRequests extends MainApplication {

    RegisterData data;

    public ProfileRequests(RegisterData data) {
        this.data = data;
    }

    public JsonObject statusAway() {
        String json = new JsonStatus().away();
        String url = "/changeStatus";
        return post_response(json, url, data);
    }

    public JsonObject statusDND(long dndTillTime, String previousStatus) {
        String json = new JsonStatus().dnd(dndTillTime, previousStatus);
        String url = "/changeStatus";
        return post_response(json, url, data);
    }

    public JsonObject statusOnline() {
        String json = new JsonStatus().online();
        String url = "/changeStatus";
        return post_response(json, url, data);
    }

    public JsonObject saveSettings(String number, long number_id, String protocol) {
        String json = new JsonSaveSettings().saveSettings(number, number_id, protocol);
        String url = "/calls/saveSettings";
        return post_response(json, url, data);
    }

    public JsonObject settingsGet() {
        String json = "{}";
        String url = "/settings/get";
        return post_response(json, url, data);
    }

    public JsonObject settingsSave() {
        String json = getJson("src/main/java/jsons/settings/save.json");
        String url = "/settings/save";
        return post_response(json, url, data);
    }

    public JsonObject setWorkingHours(Boolean isEnabled){
        String json = new JsonSettings().setWorkingHours(isEnabled);
        String url = "/settings/setWorkingHours";
        return post_response(json, url, data);
    }

    public JsonObject notificationsUpdate(){
        String json = "{\"intervalDays\":1,\"email\":\"pochta@mail.com\",\"missedMessages\":true,\"missedCalls\":true}";
        String url = "/settings/notifications/update";
        return post_response(json, url, data);
    }

    public JsonObject notificationsGet(){
        String json = "{}";
        String url = "/settings/notifications/get";
        return post_response(json, url, data);
    }

}
