import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupChatTests extends TestBase {

    private String account;
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
