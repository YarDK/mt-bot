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
        JsonObject response_channel_create = app.chat().channelCreate(local_id);
        Assert.assertEquals(
                response_channel_create.get("statusCode").getAsInt(),
                200,
                "Channel not created, result not 200");

        account = response_channel_create.getAsJsonObject("data").get("account").getAsString();
    }

    @Test
    public void testChannelEdit() {
        JsonObject response_channel_edit = app.chat().channelEdit(account);
        Assert.assertEquals(
                response_channel_edit.get("statusCode").getAsInt(),
                200,
                "Channel not edit, result not 200");
    }

    @Test
    public void testSetTypeChannel() {
        JsonObject response_channel_set_type = app.chat().channelSetType(account);
        Assert.assertEquals(
                response_channel_set_type.get("statusCode").getAsInt(),
                200,
                "Channel not set type, result not 200");

    }

    @Test
    public void testSendMessageChanel() {
        JsonObject response_channel_send_message = app.chat().channelSendMessage(account, local_id);
        Assert.assertEquals(
                response_channel_send_message.get("statusCode").getAsInt(),
                200,
                "Channel not send message, result not 200");
    }

    @AfterClass
    public void testChannelRemove() {
        JsonObject response_channel_remove = app.chat().channelRemove(account);
        Assert.assertEquals(
                response_channel_remove.get("statusCode").getAsInt(),
                200,
                "Channel not removed, result not 200");
    }
}
