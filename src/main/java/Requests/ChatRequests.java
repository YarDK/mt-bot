package Requests;

import ApplicationManager.MainApplication;
import jsons.channel.JsonChannel;
import jsons.chat.group.JsonGroupChat;
import jsons.chat.personal.JsonPersonalChat;
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
        String json = new JsonChannel().createChannel(local_id);
        String url = "/chat/create";
        return post_response(json, url, data);
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
        String json = new JsonChannel().editChannel(account);
        String url = "/chat/edit";
        return post_response(json, url, data);
    }

    public JsonObject channelSetType(String account){
        String json = new JsonChannel().channelSetType(account);
        String url = "/chat/setChannelType";
        return post_response(json, url, data);
    }

    public JsonObject channelRemove(String account){
        String json = new JsonChannel().removeChanel(account);
        String url = "/chat/removeChannel";
        return post_response(json, url, data);
    }

    public JsonObject channelSendMessage(String account, String local_id){
        String json = new JsonChannel().messageSend(account, local_id);
        String url = "/message/send";
        return post_response(json, url, data);
    }

    public JsonObject channelAddMembers(String account, String members){
        String json = new JsonChannel().addMembers(account, members);
        String url = "/chat/modify";
        return post_response(json, url, data);
    }

    public JsonObject groupChatCreate(String local_id){
        String json = new JsonGroupChat().createGroupChat(local_id);
        String url = "/chat/create";
        return post_response(json, url, data);
    }

    public JsonObject groupChatEdit(String account){
        String json = new JsonGroupChat().editGroupChat(account);
        String url = "/chat/edit";
        return post_response(json, url, data);
    }

    public JsonObject groupChatSendMessage(String account, String local_id){
        String json = new JsonGroupChat().messageSend(account, local_id);
        String url = "/message/send";
        return post_response(json, url, data);
    }

    public JsonObject groupChatRemove(String account){
        String json = new JsonGroupChat().removeGroupChat(account);
        String url = "/chat/removeChannel";
        return post_response(json, url, data);
    }

    public JsonObject personalChatCreate(String local_id, String account){
        String json = new JsonPersonalChat().createPersonalChat(local_id, account);
        String url = "/message/send";
        return post_response(json, url, data);
    }

    public JsonObject personalChatRemove(String account){
        String json = new JsonPersonalChat().removePersonalChat(account);
        String url = "/chat/remove";
        return post_response(json, url, data);
    }

}
