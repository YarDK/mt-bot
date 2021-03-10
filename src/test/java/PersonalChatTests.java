import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonalChatTests extends TestBase {

    private final String account = "401809841@mtalker.mangotele.com";
    private final String local_id = "abcdef0123456789abc" + System.currentTimeMillis();

    @Test
    public void testCreatePersonalChat() {
        int case_id = 1188419;
        JsonObject response_personal_chat_create = app.chat().personalChatCreate(local_id, account);
        int status_cod = response_personal_chat_create.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Личный чат успешно создан");
        } else {
            Assert.fail("Personal chat not created, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Личный чат не создан, код ответ " + status_cod);
        }
    }

    @Test(priority = 1)
    public void testRemovePersonalChat() {
        int case_id = 1188422;
        JsonObject response_personal_chat_remove = app.chat().personalChatRemove(account);
        int status_cod = response_personal_chat_remove.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Личный чат успешно удален");
        } else {
            Assert.fail("Personal chat not removed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Личный чат не удален, код ответ " + status_cod);
        }
    }

    @Test(enabled = false)
    public void testChatRemoveAll(){
        int case_id = 0;

        int status_cod = app.chat().chatRemoveAll().get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Все чаты удалены");
        } else {
            Assert.fail("ChatRemoveAll failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Чаты не удалены, код ответ " + status_cod);
        }
    }

    @Test
    public void testMessageHistoryForAllChats(){
        int case_id = 0;

        //придумать как доставать разные типы чатов для других тестов
        JsonObject response_message_history_for_all_chats = app.chat().messageHistoryForAllChats();
        int status_cod = response_message_history_for_all_chats.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "История всех чатов успешно получена");
        } else {
            Assert.fail("MessageHistoryForAllChats failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "История чатов не получена, код ответ " + status_cod);
        }
    }

    @Test
    public void testSmsListGet(){
        int case_id = 0;

        int status_cod = app.chat().smsListGet().get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Успешно");
        } else {
            Assert.fail("SmsListGet failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Не успешно, код ответ " + status_cod);
        }
    }

    @Test(enabled = false)
    public void testMessageNotifyRead(){
        int case_id = 0;

        int status_cod = app.chat().messageNotifyRead(account).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Уведомление о прочтении успешно");
        } else {
            Assert.fail("MessageNotifyRead failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Уведомление о прочтении не успешно, код ответ " + status_cod);
        }
    }

    @Test
    public void testChatUploadAvatar(){
        int case_id = 0;
        //Сделать значение динамичным
        String group_chat = "{21dfcc12-503d-4d2b-b316-ec0b72022ff0}@conference.mtalker.mangotele.com";

        String file_name = "testavatar.png";
        String file_extension = "png";


        int status_cod = app.chat().chatUploadAvatar(group_chat, file_name, file_extension).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Аватар успешно установлен");
        } else {
            Assert.fail("ChatUploadAvatar failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Аватар не удалось установить, код ответ " + status_cod);
        }
    }

    @Test(priority = 1)
    public void testChatRemoveAvatar(){
        app.waiter(2000);

        int case_id = 0;
        //Сделать значение динамичным
        String group_chat = "{21dfcc12-503d-4d2b-b316-ec0b72022ff0}@conference.mtalker.mangotele.com";

        int status_cod = app.chat().chatRemoveAvatar(group_chat).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Аватар успешно удален");
        } else {
            Assert.fail("ChatRemoveAvatar failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Аватар не удален, код ответ " + status_cod);
        }
    }

}
