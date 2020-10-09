import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonalChatTests extends TestBase {

    private String account = "401809841@mtalker.mangotele.com";
    private final String local_id = "abcdef0123456789abc" + System.currentTimeMillis();

    @BeforeClass
    public void testCreatePersonalChat() {
        JsonObject response_personal_chat_create = app.chat().personalChatCreate(local_id, account);
        Assert.assertEquals(
                response_personal_chat_create.get("statusCode").getAsInt(),
                200,
                "Personal chat not created, result not 200");
    }

    @AfterClass
    public void testRemovePersonalChat() {
        JsonObject response_personal_chat_remove = app.chat().personalChatRemove(account);
        Assert.assertEquals(
                response_personal_chat_remove.get("statusCode").getAsInt(),
                200,
                "Personal chat not removed, result not 200");
    }
}
