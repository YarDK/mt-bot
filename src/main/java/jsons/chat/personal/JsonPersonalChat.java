package jsons.chat.personal;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.json.Json;

import javax.swing.*;

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

    public String chatRemoveAll(){
        JsonObject chat_remove_all = new JsonObject();
        chat_remove_all.addProperty("skipCalls", true);
        return chat_remove_all.toString();
    }

    public String messageHistory(){
        JsonObject message_history = new JsonObject();
        message_history.addProperty("latest", 1);
        message_history.addProperty("limit", 100);


        JsonArray talkers_arr = new JsonArray();
        JsonObject talkers = new JsonObject();
        talkers.addProperty("account", "401530378@mtalker.mangotele.com");
        talkers_arr.add(talkers);

        message_history.add("talkers", talkers_arr);
        message_history.addProperty("toId", "304959329615186528");
        return message_history.toString();
    }

    public String smsListGet(){
        JsonObject sms_list_get = new JsonObject();
        sms_list_get.addProperty("beforeTime", 1615303118);
        sms_list_get.addProperty("limit", 50);
        sms_list_get.addProperty("withNumbers", false);
        return sms_list_get.toString();
    }

    public String messageNotifyRead(String account){
        JsonObject message_notify_read = new JsonObject();
        message_notify_read.addProperty("account", account);
        message_notify_read.addProperty("sid", "304959329615186528");
        return message_notify_read.toString();
    }


}
