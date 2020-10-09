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
        JsonObject response_group_chat_create = app.chat().groupChatCreate(local_id);
        Assert.assertEquals(
                response_group_chat_create.get("statusCode").getAsInt(),
                200,
                "Group chat not created, result not 200");

        account = response_group_chat_create.getAsJsonObject("data").get("account").getAsString();
    }

    @Test(priority = 1)
    public void testGroupChatEdit(){
        JsonObject response_group_chat_edit = app.chat().groupChatEdit(account);
        Assert.assertEquals(
                response_group_chat_edit.get("statusCode").getAsInt(),
                200,
                "Group chat not created, result not 200");
    }

    @Test(priority = 1)
    public void testGroupChatSendMessage(){
        JsonObject response_group_send_message = app.chat().groupChatSendMessage(account, local_id);
        Assert.assertEquals(
                response_group_send_message.get("statusCode").getAsInt(),
                200,
                "Message no sand in group chat, result not 200");
    }

    @AfterClass
    public void testGroupChatRemove(){
        JsonObject response_group_chat_remove = app.chat().groupChatRemove(account);
        Assert.assertEquals(
                response_group_chat_remove.get("statusCode").getAsInt(),
                200,
                "Group chat not removed, result not 200");
    }

}
