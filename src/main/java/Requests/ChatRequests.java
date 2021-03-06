package Requests;

import ApplicationManager.RunnerApplication;
import com.jayway.restassured.builder.MultiPartSpecBuilder;
import com.jayway.restassured.response.Response;
import jsons.channel.JsonChannel;
import jsons.chat.group.JsonGroupChat;
import jsons.chat.personal.JsonPersonalChat;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import java.io.File;

public class ChatRequests extends RunnerApplication {
    
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

    public JsonObject personalChatCreate(String local_id, String account, String message){
        String json = new JsonPersonalChat().createPersonalChat(local_id, account, message);
        String url = "/message/send";
        return post_response(json, url, data);
    }

    public JsonObject personalChatRemove(String account){
        String json = new JsonPersonalChat().removePersonalChat(account);
        String url = "/chat/remove";
        return post_response(json, url, data);
    }

    public JsonObject chatRemoveAll(){
        String json = new JsonPersonalChat().chatRemoveAll();
        String url = "/chat/removeAll";
        return post_response(json, url, data);
    }

    public JsonObject messageHistoryForAccount(String account){
        String json = new JsonPersonalChat().messageHistoryForAccount(account);
        String url = "/message/history";
        return post_response(json, url, data);
    }

    public JsonObject messageHistoryForAllChats(){
        String json = new JsonPersonalChat().messageHistoryForAllChats();
        String url = "/message/history";
        return post_response(json, url, data);
    }

    public JsonObject smsListGet(){
        String json = new JsonPersonalChat().smsListGet();
        String url = "/smslist/get";
        return post_response(json, url, data);
    }

    public JsonObject messageNotifyRead(String account){
        String json = new JsonPersonalChat().messageNotifyRead(account);
        String url = "/message/notifyRead";
        return post_response(json, url, data);
    }

    public JsonObject chatRemoveAvatar(String account){
        String json = new JsonPersonalChat().chatRemoveAvatar(account);
        String url = "/chat/removeAvatar";
        return post_response(json, url, data);
    }

    public JsonObject chatUploadAvatar(String account, String file_name, String file_extension){
        String resources = "src/test/resources/";

        File file_avatar = new File(resources + file_name);
        String url = "/chat/uploadAvatar";

        System.out.println("\nRequest: "+url+":\n");
        // ???????????????? ?????????? ???? ????????????
        String post_request = RestAssured.given()
                .multiPart(new MultiPartSpecBuilder(file_avatar)
                        .controlName("userfile")
                        .fileName(file_name)
                        .mimeType("image/" + file_extension)
                        .build())
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .param("account", account)
                .post(data.getUrl_4talk() + url).asString();
        System.out.println("Response UploadAvatar:\n" + post_request);
        return JsonParser.parseString(post_request).getAsJsonObject();
    }


    public Response getAvatar(String avatar_id){
        String url = data.getUrl_fs() + "/avatars/" + avatar_id;
        return get_response(url);
    }

    public JsonObject chatOnline(String account){
        String url = "/chat/online";
        String json = new JsonGroupChat().chatOnline(account);
        return post_response(json,url,data);
    }

    public JsonObject chatOffline(String account){
        String url = "/chat/offline";
        String json = new JsonGroupChat().chatOffline(account);;
        return post_response(json,url,data);
    }

    public JsonObject chatMuteOn(String account){
        String url = "/chat/mute";
        String json = new JsonGroupChat().chatMuteOn(account);
        return post_response(json,url,data);
    }

    public JsonObject chatMuteOff(String account){
        String url = "/chat/mute";
        String json = new JsonGroupChat().chatMuteOff(account);
        return post_response(json,url,data);
    }

    public JsonObject messageEdit(String account, String sid, String localId){
        String url = "/message/edit";
        String json = new JsonPersonalChat().messageEdit(account, sid, localId);
        return post_response(json,url,data);
    }

    public JsonObject messageSendSms(String local_id){
        String url = "/message/sendSms";
        String json = new JsonPersonalChat().messageSendSms(local_id);
        return post_response(json,url,data);
    }

    public JsonObject messageResendSms(String sid){
        String url = "/message/resendSms";
        String json = new JsonPersonalChat().messageResendSms(sid);
        return post_response(json,url,data);
    }

    public JsonObject messageResendFax(String sid){
        String url = "/message/resendFax";
        String json = new JsonPersonalChat().messageResendFax(sid);
        return post_response(json,url,data);
    }

    public JsonObject messageRemove(String account, String sid){
        String url = "/message/remove";
        String json = new JsonPersonalChat().messageRemove(account, sid);
        return post_response(json,url,data);
    }

    public JsonObject messageHistory(String account){
        String url = "/message/history";
        String json = new JsonPersonalChat().messageHistory(account);
        return post_response(json,url,data);
    }

    public JsonObject messageNotifyTyping(String account){
        String url = "/message/notifyTyping";
        String json = new JsonPersonalChat().messageNotifyTyping(account);
        return post_response(json,url,data);
    }

    public JsonObject messageNotifyDelivered(String account, String sid){
        String url = "/message/notifyDelivered";
        String json = new JsonPersonalChat().messageNotifyDelivered(account, sid);
        return post_response(json,url,data);
    }

    public JsonObject messageNotifyReadAll(String account, String sid){
        String url = "/message/notifyReadAll";
        String json = new JsonPersonalChat().messageNotifyReadAll(account, sid);
        return post_response(json,url,data);
    }

    public JsonObject messageForward(String to, String sid, String local_id){
        String url = "/message/forward";
        String json = new JsonPersonalChat().messageForward(to, sid, local_id);
        return post_response(json,url,data);
    }

    public JsonObject messageSearchInPersonalChat(String account){
        String url = "/message/search";
        String json = new JsonPersonalChat().messageSearchInPersonalChat(account);
        return post_response(json,url,data);
    }

    public JsonObject messageRemoveByType(String account, String type){
        String url = "/message/forward";
        String json = new JsonPersonalChat().messageRemoveByType(account, type);
        return post_response(json,url,data);
    }

}
