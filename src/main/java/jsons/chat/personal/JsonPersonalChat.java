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

    public String messageHistoryForAccount(String account){
        JsonObject message_history = new JsonObject();
        message_history.addProperty("latest", 1);
        message_history.addProperty("limit", 100);


        JsonArray talkers_arr = new JsonArray();
        JsonObject talkers = new JsonObject();
        talkers.addProperty("account", account);
        talkers_arr.add(talkers);

        message_history.add("talkers", talkers_arr);
        message_history.addProperty("toId", "304959329615186528");
        return message_history.toString();
    }

    public String messageHistoryForAllChats(){
        JsonObject message_history = new JsonObject();
        message_history.addProperty("latest", 1);
        message_history.addProperty("limit", 100);

        message_history.addProperty("allChats", true);
        message_history.addProperty("includeUnread", 1);
        message_history.addProperty("unreadLimit", 100);

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

    public String chatRemoveAvatar(String account){
        JsonObject chat_remove_avatar = new JsonObject();
        chat_remove_avatar.addProperty("account", account);
        return chat_remove_avatar.toString();
    }

    public String chatUploadAvatar(String account){
        JsonObject chat_upload_avatar = new JsonObject();
        chat_upload_avatar.addProperty("account", account);
        return chat_upload_avatar.toString();
    }

    public String messageEdit(String account, String sid, String localId){
        JsonObject json_messages = new JsonObject();
        JsonObject messages = new JsonObject();
        messages.addProperty("localId", localId);

        JsonObject payload_into = new JsonObject();
        payload_into.addProperty("body", "edited_text_message");

        messages.add("payload", payload_into);
        messages.addProperty("sid", sid);
        messages.addProperty("to", account);

        JsonArray messages_arr = new JsonArray();
        messages_arr.add(messages);
        json_messages.add("messages", messages_arr);
        return json_messages.toString();
    }

}
