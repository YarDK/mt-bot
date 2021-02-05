package jsons;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonPersonalChat {

    public String createPersonalChat(String local_id, String account){
        JsonObject payload_into = new JsonObject();
        payload_into.addProperty("body","Personal chat for authotesting");

        JsonObject messages_into = new JsonObject();
        messages_into.addProperty("localId",local_id);
        messages_into.add("payload", payload_into);
        messages_into.addProperty("to", account);
        messages_into.addProperty("type","text");
        JsonArray messages_arr = new JsonArray();
        messages_arr.add(messages_into);

        JsonObject main_json = new JsonObject();
        main_json.add("messages", messages_arr);

        return main_json.toString();
    }


    public String removePersonalChat(String account){
        JsonObject main_json = new JsonObject();
        main_json.addProperty("account", account);
        return main_json.toString();
    }
}
