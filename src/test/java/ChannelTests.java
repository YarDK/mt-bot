import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChannelTests extends TestBase {

    private String account;
    private final String local_id = "abcdef0123456789abc" + System.currentTimeMillis();

    @BeforeClass
    public void testChannelCreate() {
        int case_id = 1188374;
        JsonObject response_channel_create = app.chat().channelCreate(local_id);
        int status_cod = response_channel_create.get("statusCode").getAsInt();

        if(status_cod == 200){
            account = response_channel_create.getAsJsonObject("data").get("account").getAsString();
            app.testrail().setResultCase(case_id, "passed", "Канал создан успешно:\n" + account);
        } else {
            Assert.fail("Channel not created, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Канал не создан, код ответ " + status_cod);
        }

        //Assert.assertEquals(response_channel_create.get("statusCode").getAsInt(), 200, "Channel not created, result not 200");
    }

    @Test
    public void testChannelEdit() {
        int case_id = 1188377;
        JsonObject response_channel_edit = app.chat().channelEdit(account);
        int status_cod = response_channel_edit.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Канал успешно изменен");
        } else {
            Assert.fail("Channel not edit, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Канал не изменен, код ответ " + status_cod);
        }

        //Assert.assertEquals(response_channel_edit.get("statusCode").getAsInt(), 200,"Channel not edit, result not 200");
    }

    @Test
    public void testSetTypeChannel() {
        int case_id = 1188380;
        JsonObject response_channel_set_type = app.chat().channelSetType(account);
        int status_cod = response_channel_set_type.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Тип канала успешно изменен");
        } else {
            Assert.fail("Channel not set type, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Тип канал не изменен, код ответ " + status_cod);
        }

        //Assert.assertEquals(response_channel_set_type.get("statusCode").getAsInt(), 200,"Channel not set type, result not 200");

    }


    @Test
    public void testSendMessageChanel() {
        int case_id = 1188383;
        JsonObject response_channel_send_message = app.chat().channelSendMessage(account, local_id);
        int status_cod =  response_channel_send_message.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Сообщение успешно отправлено в канал");
        } else {
            Assert.fail("Channel not send message, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Сообщение в канала не отправле, код ответ " + status_cod);
        }

        //Assert.assertEquals(response_channel_send_message.get("statusCode").getAsInt(), 200, "Channel not send message, result not 200");
    }

    @AfterClass
    public void testChannelRemove() {
        int case_id = 1188386;
        JsonObject response_channel_remove = app.chat().channelRemove(account);
        int status_cod = response_channel_remove.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Канал успешно удален");
        } else {
            Assert.fail("Channel not send message, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Канал не уадален, код ответ " + status_cod);
        }

        //Assert.assertEquals(response_channel_remove.get("statusCode").getAsInt(), 200, "Channel not removed, result not 200");
    }
}
