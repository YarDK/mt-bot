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

    public String callsSearch(String query){
            JsonObject calls_search = new JsonObject();
            calls_search.addProperty("limit", 100);
            calls_search.addProperty("onlyMissed", false);
            calls_search.addProperty("query", query);
            // toId: String, опциональный - Диапазон выборки SID ∈ (toId..0), в обратном хронологическом порядке.
            // Если не указано, выборка начинается с конца истории
            //calls_search.addProperty("toId", "417518919190127421");
        return calls_search.toString();
    }

    // Синхронизация журнала звонков
    public String callsSync(){
        JsonObject calls_sync = new JsonObject();
        calls_sync.addProperty("limit", 500);
        calls_sync.addProperty("sinceId","317519551034404480");
        return calls_sync.toString();
    }

    // Дозагрузка из журнала звонков
    public String callsGet(){
        JsonObject calls_sync = new JsonObject();
        calls_sync.addProperty("limit", 100);
        calls_sync.addProperty("toId","317519551034404480");
        return calls_sync.toString();
    }


}