package jsons.calls;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.json.Json;

public class JsonCalls {

    public String getRecord(String sid) {
        JsonObject main_json = new JsonObject();
        main_json.addProperty("sid", sid);
        return main_json.toString();
    }

    public String callsHistory(String number){
        JsonObject calls_history = new JsonObject();
        calls_history.addProperty("limit", 50);

        JsonArray numbers_arr = new JsonArray();
        numbers_arr.add(number);

        calls_history.add("numbers", numbers_arr);
        return calls_history.toString();
    }

    public String callsNotifyAnswered(String callId, String contextId){
        JsonObject calls_notify_answered = new JsonObject();
        calls_notify_answered.addProperty("callId", callId);
        calls_notify_answered.addProperty("contextId", contextId);
        return calls_notify_answered.toString();
    }

    public String callsNotifyStarted(String contextId){
        JsonObject calls_notify_started = new JsonObject();
        calls_notify_started.addProperty("contextId", contextId);
        return calls_notify_started.toString();
    }


}