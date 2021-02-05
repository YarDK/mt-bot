package Requests;

import ApplicationManager.MainApplication;
import jsons.JsonChannel;
import jsons.JsonGroupChat;
import jsons.JsonPersonalChat;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class ChatRequests extends MainApplication {
    
    RegisterData data;

    public ChatRequests(RegisterData data) {
        this.data = data;
    }

    public JsonObject channelCreate(String local_id){
        String json_channel_create = new JsonChannel().createChannel(local_id);
        System.out.println("\njson_channel_create:\n" + json_channel_create);
        String url = data.getUrl_4talk() + "/chat/create";
        String channel_create = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_channel_create)
                .post(url).asString();
        System.out.println("\nResponse channel create:\n" + channel_create);
        return JsonParser.parseString(channel_create).getAsJsonObject();
    }

    public JsonObject channelUserOnline(String account){
        String url = data.getUrl_4talk() + "/chat/online";
        String channel_user_online = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .parameter("account", account)
                .post(url).asString();
        System.out.println("\nResponse channel_user_online:\n" + channel_user_online);
        return JsonParser.parseString(channel_user_online).getAsJsonObject();
    }

    public JsonObject channelEdit(String account){
        String json_channel_edit = new JsonChannel().editChannel(account);
        System.out.println("\njson_channel_edit:\n" + json_channel_edit);
        String url = data.getUrl_4talk() + "/chat/edit";
        String channel_edit = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_channel_edit)
                .post(url).asString();
        System.out.println("\nResponse channel edit:\n" + channel_edit);
        return JsonParser.parseString(channel_edit).getAsJsonObject();
    }

    public JsonObject channelSetType(String account){
        String json_chanel_set_type = new JsonChannel().channelSetType(account);
        String url = data.getUrl_4talk() + "/chat/setChannelType";
        String channel_set_type = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_chanel_set_type)
                .post(url).asString();
        System.out.println("\nResponse channel set type:\n" + channel_set_type);
        return JsonParser.parseString(channel_set_type).getAsJsonObject();
    }

    public JsonObject channelRemove(String account){
        String json_channel_remove = new JsonChannel().removeChanel(account);
        System.out.println("\njson_channel_remove:\n" + json_channel_remove);
        String url = data.getUrl_4talk() + "/chat/removeChannel";
        String channel_remove = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_channel_remove)
                .post(url).asString();
        System.out.println("\nResponse channel remove:\n" + channel_remove);
        return JsonParser.parseString(channel_remove).getAsJsonObject();
    }

    public JsonObject channelSendMessage(String account, String local_id){
        String json_channel_send_message = new JsonChannel().messageSend(account, local_id);
        System.out.println("\njson_channel_send_message:\n" + json_channel_send_message);
        String url = data.getUrl_4talk() + "/message/send";
        String channel_send_message = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_channel_send_message)
                .post(url).asString();
        System.out.println("\nResponse channel send message:\n" + channel_send_message);
        return JsonParser.parseString(channel_send_message).getAsJsonObject();
    }

    public JsonObject channelAddMembers(String account, String members){
        String json_channel_add_members = new JsonChannel().addMembers(account, members);
        System.out.println("\njson_channel_add_members:\n" + json_channel_add_members);
        String url = data.getUrl_4talk() + "/chat/modify";
        String channel_add_members = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_channel_add_members)
                .post(url).asString();
        System.out.println("\nResponse channel add members:\n" + channel_add_members);
        return JsonParser.parseString(channel_add_members).getAsJsonObject();
    }

    public JsonObject groupChatCreate(String local_id){
        String json_group_chat_create = new JsonGroupChat().createGroupChat(local_id);
        System.out.println("\njson_group_chat_create:\n" + json_group_chat_create);
        String url = data.getUrl_4talk() + "/chat/create";
        String group_chat_create = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_group_chat_create)
                .post(url).asString();
        System.out.println("\nResponse group chat create:\n" + group_chat_create);
        return JsonParser.parseString(group_chat_create).getAsJsonObject();
    }

    public JsonObject groupChatEdit(String account){
        String json_chat_edit = new JsonGroupChat().editGroupChat(account);
        System.out.println("\njson_chat_edit:\n" + json_chat_edit);
        String url = data.getUrl_4talk() + "/chat/edit";
        String group_chat_edit = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_chat_edit)
                .post(url).asString();
        System.out.println("\nResponse group chat edit:\n" + group_chat_edit);
        return JsonParser.parseString(group_chat_edit).getAsJsonObject();
    }

    public JsonObject groupChatSendMessage(String account, String local_id){
        String json_group_send_message = new JsonGroupChat().messageSend(account, local_id);
        System.out.println("\njson_group_send_message:\n" + json_group_send_message);
        String url = data.getUrl_4talk() + "/message/send";
        String group_send_message = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_group_send_message)
                .post(url).asString();
        System.out.println("\nResponse group chat send message:\n" + group_send_message);
        return JsonParser.parseString(group_send_message).getAsJsonObject();
    }

    public JsonObject groupChatRemove(String account){
        String json_group_chat_remove = new JsonGroupChat().removeGroupChat(account);
        System.out.println("\njson_group_chat_remove:\n" + json_group_chat_remove);
        String url = data.getUrl_4talk() + "/chat/removeChannel";
        String group_chat_remove = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_group_chat_remove)
                .post(url).asString();
        System.out.println("\nResponse group chat remove:\n" + group_chat_remove);
        return JsonParser.parseString(group_chat_remove).getAsJsonObject();
    }

    public JsonObject personalChatCreate(String local_id, String account){
        String json_personal_chat_create = new JsonPersonalChat().createPersonalChat(local_id, account);
        System.out.println("\njson_personal_chat_create:\n" + json_personal_chat_create);
        String url = data.getUrl_4talk() + "/message/send";
        String personal_chat_create = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_personal_chat_create)
                .post(url).asString();
        System.out.println("\nResponse personal chat create:\n" + personal_chat_create);
        return JsonParser.parseString(personal_chat_create).getAsJsonObject();
    }

    public JsonObject personalChatRemove(String account){
        String json_personal_chat_remove = new JsonPersonalChat().removePersonalChat(account);
        System.out.println("\njson_personal_chat_remove:\n" + json_personal_chat_remove);
        String url = data.getUrl_4talk() + "/chat/remove";
        String personal_chat_remove = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_personal_chat_remove)
                .post(url).asString();
        System.out.println("\nResponse personal chat remove:\n" + personal_chat_remove);
        return JsonParser.parseString(personal_chat_remove).getAsJsonObject();
    }
}
