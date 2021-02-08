package jsons.calls;

import com.google.gson.JsonObject;

public class JsonCalls {

    public String getRecord(String sid) {
        JsonObject main_json = new JsonObject();
        main_json.addProperty("sid", sid);
        return main_json.toString();
    }
}