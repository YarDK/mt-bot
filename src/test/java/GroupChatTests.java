import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupChatTests extends TestBase {

    private String account;
    private String avatar_id;
    private final String local_id = "abcdef0123456789abc" + System.currentTimeMillis();

    @BeforeClass
    public void testGroupChatCreate() {
        int case_id = 1188407;
        JsonObject response_group_chat_create = app.chat().groupChatCreate(local_id);
        int status_cod = response_group_chat_create.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Групповой част успешно создан");
            account = response_group_chat_create.getAsJsonObject("data").get("account").getAsString();
        } else {
            Assert.fail("Group chat not created, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Групповой чат не создан, код ответ " + status_cod);
        }
    }

    @Test
    public void testChatUploadAvatar(){
        int case_id = 1347209;

        String file_name = "testavatar.png";
        String file_extension = "png";

        JsonObject response_avatar_upload = app.chat().chatUploadAvatar(account, file_name, file_extension);
        int status_cod = response_avatar_upload.get("statusCode").getAsInt();
        avatar_id = response_avatar_upload.getAsJsonObject("data").get("avatarId").getAsString();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Аватар успешно установлен");
        } else {
            Assert.fail("ChatUploadAvatar failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Аватар не удалось установить, код ответ " + status_cod);
        }
    }

    @Test(priority = 1)
    public void testGroupChatEdit(){
        int case_id = 1188410;
        JsonObject response_group_chat_edit = app.chat().groupChatEdit(account);
        int status_cod = response_group_chat_edit.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Групповой чат успешно изменен");
        } else {
            Assert.fail("Group chat not update, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Групповой чат не изменен, код ответ " + status_cod);
        }

    }

    @Test(priority = 1)
    public void testGroupChatSendMessage(){
        int case_id = 1188413;
        JsonObject response_group_send_message = app.chat().groupChatSendMessage(account, local_id);
        int status_cod = response_group_send_message.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Сообщение успешно отрпрвлено в групповой чат");
        } else {
            Assert.fail("Message no sand in group chat, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Сообщение не отрпрвлено в групповой чат, код ответ " + status_cod
            );
        }
    }

    @Test(priority = 1)
    public void testGetAvatar(){
        app.waiter(1000);

        int case_id = 0;
        Response response_get_avatar = app.chat().getAvatar(avatar_id);
        int status_cod = response_get_avatar.getStatusCode();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id,
                    "passed",
                    "Аватар успешно получен. Id file:\n" + response_get_avatar.getHeader("Content-Disposition"));
        } else {
            Assert.fail("GetAvatar failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Аватар не получен, код ответ " + status_cod);
        }
    }


    @Test(priority = 2, enabled = false)
    public void testChatRemoveAvatar(){
        app.waiter(2000);

        int case_id = 1347212;
        int status_cod = app.chat().chatRemoveAvatar(account).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Аватар успешно удален");
        } else {
            Assert.fail("ChatRemoveAvatar failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Аватар не удален, код ответ " + status_cod);
        }
    }

    @Test(priority = 3)
    public void testGroupChatOffline(){
        int case_id = 0;
        JsonObject response_group_chat_online = app.chat().chatOffline(account);
        int status_cod = response_group_chat_online.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Успешно покинут групповой чат");
        } else {
            Assert.fail("Group chat not offline, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Групповой чат покинуть не удалось, код ответ " + status_cod
            );
        }
    }

    @Test(priority = 4)
    public void testGroupChatOnline(){
        int case_id = 0;
        JsonObject response_group_chat_online = app.chat().chatOnline(account);
        int status_cod = response_group_chat_online.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Успешно вернулся в групповой чат");
        } else {
            Assert.fail("Group chat not online, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "В групповой чат вернуться не удалось, код ответ " + status_cod
            );
        }
    }

    @Test(priority = 5)
    public void testGroupChatMuteOn(){
        int case_id = 0;
        JsonObject response_group_chat_online = app.chat().chatMuteOn(account);
        int status_cod = response_group_chat_online.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Групповой чат успешно размьючен");
        } else {
            Assert.fail("Group chat mute not on, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Групповой чат не размьючен, код ответ " + status_cod
            );
        }
    }

    @Test(priority = 6)
    public void testGroupChatMuteOff(){
        int case_id = 0;
        JsonObject response_group_chat_online = app.chat().chatMuteOff(account);
        int status_cod = response_group_chat_online.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Групповой чат успешно замьючен");
        } else {
            Assert.fail("Group chat mute not off, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Групповой чат не замьючен, код ответ " + status_cod
            );
        }
    }

    @AfterClass
    public void testGroupChatRemove(){
        int case_id = 1188416;
        JsonObject response_group_chat_remove = app.chat().groupChatRemove(account);
        int status_cod = response_group_chat_remove.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Групповой чат успешно удален");
        } else {
            Assert.fail("Message no sand in group chat, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Групповой чат не удален, код ответ " + status_cod
            );
        }
    }

}
