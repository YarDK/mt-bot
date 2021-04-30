import com.google.gson.JsonObject;
import org.junit.After;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.*;

public class PersonalChatTests extends TestBase {

    private final String account = "401809841@mtalker.mangotele.com";
    private final String local_id = "abcdef0123456789abc" + System.currentTimeMillis();
    private String msg_sid;
    private String sms_sid;
    private String fax_sid;

    @BeforeTest
    public void testCreatePersonalChat() {
        int case_id = 1188419;
        JsonObject response_personal_chat_create = app.chat().personalChatCreate(local_id, account);
        int status_cod = response_personal_chat_create.get("statusCode").getAsInt();
        msg_sid = response_personal_chat_create
                .get("data").getAsJsonArray().get(0).getAsJsonObject().get("sid").getAsString();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Личный чат успешно создан");
        } else {
            Assert.fail("Personal chat not created, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Личный чат не создан, код ответ " + status_cod);
        }
    }

    @Test
    public void testMessageEdit(){
        int case_id = 1404317;
        JsonObject response_message_edit = app.chat().messageEdit(account,msg_sid,local_id);
        int status_cod = response_message_edit.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Сообщение успешно изменено");
        } else {
            Assert.fail("Message edit failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Сообщение не удалось изменить, код ответ " + status_cod);
        }
    }

    @Test
    public void testMessageForward(){
        int case_id = 1404320;
        JsonObject response_message_edit = app.chat().messageForward(account,msg_sid,local_id);
        int status_cod = response_message_edit.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Сообщение успешно переслано");
        } else {
            Assert.fail("MessageForward failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Сообщение не удалось переслать, код ответ " + status_cod);
        }
    }

    @Test
    public void testMessageSearchInPersonalChat(){
        int case_id = 1404323;
        JsonObject response_message_edit = app.chat().messageSearchInPersonalChat(account);
        int status_cod = response_message_edit.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Сообщение успешно найдено");
        } else {
            Assert.fail("MessageSearchInPersonalChat failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Сообщение не удалось найти, код ответ " + status_cod);
        }
    }


    @Test(enabled = false)
    public void testMessageRemoveByType(){
        int case_id = 1404326;
        // Не очень понятно как этот метод работает
        // На клиенте реализации такой нет
        String type = "call";
        JsonObject response_message_edit = app.chat().messageRemoveByType(account, type);
        int status_cod = response_message_edit.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Сообщения с типом '"+type+"' успешно удалены");
        } else {
            Assert.fail("MessageRemoveByType failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Сообщения с типом '"+type+"' не удалось удалить, код ответ " + status_cod
            );
        }
    }

    @Test
    public void testMessageRemove(){
        int case_id = 1404329;

        // Оправляем другое сообщения, что бы потом удалить его и не афектить другие кейсы
        String local_id = "123def0123456789abc" + System.currentTimeMillis();
        JsonObject response_message_send = app.chat().personalChatCreate(local_id, account); // Создание личного чата = отправка сообщения
        int status_cod_send = response_message_send.get("statusCode").getAsInt();
        if(status_cod_send != 200){
            Assert.fail("Message send failed (remove case), result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Не удалось отправить сообщение (кейс с удалением), код ответ " + status_cod_send
            );
        }
        String sid = response_message_send
                .get("data").getAsJsonArray().get(0).getAsJsonObject().get("sid").getAsString();

        // Удаление ранее отправленного сообщения
        app.waiter(2000);
        JsonObject response_message_remove = app.chat().messageRemove(account, sid);
        int status_cod_remove = response_message_remove.get("statusCode").getAsInt();

        if(status_cod_remove == 200){
            app.testrail().setResultCase(case_id, "passed", "Сообщение удалено");
        } else {
            Assert.fail("Message Remove failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Не удалось удалить сообщение, код ответ " + status_cod_remove
            );
        }
    }


    @Test(enabled = false)
    public void testChatRemoveAll(){
        int case_id = 1347197;

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
        int case_id = 1347200;

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
    public void testMessageSentSms(){
        int case_id = 1404332;

        JsonObject response_message_send_sms = app.chat().messageSendSms(local_id);
        sms_sid = response_message_send_sms.get("data").getAsJsonArray().get(0).getAsJsonObject().get("sid").getAsString();
        int status_cod = response_message_send_sms.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Смс успешно отправлено");
        } else {
            Assert.fail("MessageSentSms failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Смс не отправлено, код ответ " + status_cod);
        }
    }

    @Test
    public void testMessageHistory(){
        int case_id = 1404335;

        JsonObject response_message_history = app.chat().messageHistory(account);
        int status_cod = response_message_history.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "История сообщений успешно запрошена");
        } else {
            Assert.fail("MessageHistory failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Не удалось запросить историю сообщений, код ответ " + status_cod
            );
        }
    }

    @Test
    public void testMessageNotifyTyping(){
        int case_id = 1404338;

        JsonObject response_message_history = app.chat().messageNotifyTyping(account);
        int status_cod = response_message_history.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Информация о печати сообщения успешно передано");
        } else {
            Assert.fail("MessageNotifyTyping failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Не удалось передать Typing, код ответ " + status_cod
            );
        }
    }

    @Test
    public void testMessageNotifyDelivered(){
        int case_id = 1404341;

        JsonObject response_message_history = app.chat().messageNotifyDelivered(account, msg_sid);
        int status_cod = response_message_history.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Уведомление о получении сообщения успешно отправлено");
        } else {
            Assert.fail("MessageNotifyDelivered failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Уведомление о получении сообщения не отправлено, код ответ " + status_cod
            );
        }
    }
    @Test
    public void testMessageNotifyReadAll(){
        int case_id = 1404344;

        JsonObject response_message_history = app.chat().messageNotifyReadAll(account, msg_sid);
        int status_cod = response_message_history.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Уведомление о прочтении всех сообщений успешно");
        } else {
            Assert.fail("MessageHistory failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Уведомление о прочтении всех сообщений не успешно, код ответ " + status_cod
            );
        }
    }

    @Test(priority = 1)
    public void testMessageResendSms(){
        int case_id = 1404347;

        JsonObject response_message_resend_sms = app.chat().messageResendSms(sms_sid);
        int status_cod = response_message_resend_sms.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "СМС уже доставено, повторная отправка не требуется");
        } else {
            Assert.fail("MessageResendSms failed, result 200");
            app.testrail().setResultCase(case_id, "failed", "Ошибка при попытки переотрпавить смс, код ответ " + status_cod);
        }
    }

    @Test(enabled = false, priority = 1)
    public void testMessageResendFax(){
        int case_id = 0;

        JsonObject response_message_resend_sms = app.chat().messageResendFax(fax_sid);
        int status_cod = response_message_resend_sms.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Факс уже доставен, повторная отправка не требуется");
        } else {
            Assert.fail("MessageResendFax failed, result 200");
            app.testrail().setResultCase(case_id, "failed", "Ошибка при попытки переотрпавить факс, код ответ " + status_cod);
        }
    }

    @Test
    public void testSmsListGet(){
        int case_id = 1347203;

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
        int case_id = 1347206;

        int status_cod = app.chat().messageNotifyRead(account).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Уведомление о прочтении успешно");
        } else {
            Assert.fail("MessageNotifyRead failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Уведомление о прочтении не успешно, код ответ " + status_cod);
        }
    }

    @AfterTest
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


}
