package Requests;

import ApplicationManager.MainApplication;
import jsons.settings.JsonSaveSettings;
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
        String json_set_status_away = new JsonStatus().away();
        System.out.println("\njson_set_status_away:\n" + json_set_status_away);
        String url = data.getUrl_4talk() + "/changeStatus";
        String set_status_away = RestAssured.given()
                .auth().preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_set_status_away)
                .post(url).asString();
        System.out.println("\nResponse set_status_away:\n" + set_status_away);
        return JsonParser.parseString(set_status_away).getAsJsonObject();
    }

    public JsonObject statusDND(long dndTillTime, String previousStatus) {
        String json_set_status_dnd = new JsonStatus().dnd(dndTillTime, previousStatus);
        System.out.println("\njson_set_status_dnd:\n" + json_set_status_dnd);
        String url = data.getUrl_4talk() + "/changeStatus";
        String set_status_dnd = RestAssured.given()
                .auth().preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_set_status_dnd)
                .post(url).asString();
        System.out.println("\nResponse set_status_dnd:\n" + set_status_dnd);
        return JsonParser.parseString(set_status_dnd).getAsJsonObject();
    }

    public JsonObject statusOnline() {
        String json_set_status_online = new JsonStatus().online();
        System.out.println("\njson_set_status_online:\n" + json_set_status_online);
        String url = data.getUrl_4talk() + "/changeStatus";
        String set_status_online = RestAssured.given()
                .auth().preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_set_status_online)
                .post(url).asString();
        System.out.println("\nResponse set_status_online:\n" + set_status_online);
        return JsonParser.parseString(set_status_online).getAsJsonObject();
    }

    public JsonObject saveSettings(String number, long number_id, String protocol) {
        String json_save_settings = new JsonSaveSettings().saveSettings(number, number_id, protocol);
        System.out.println("\njson_save_settings:\n" + json_save_settings);
        String url = data.getUrl_4talk() + "/calls/saveSettings";
        String save_settings = RestAssured.given()
                .auth().preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_save_settings)
                .post(url).asString();
        System.out.println("\nResponse save_settings:\n" + save_settings);
        return JsonParser.parseString(save_settings).getAsJsonObject();
    }

}
