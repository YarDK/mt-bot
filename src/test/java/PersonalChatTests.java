import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonalChatTests extends TestBase {

    private String account = "401809841@mtalker.mangotele.com";
    private final String local_id = "abcdef0123456789abc" + System.currentTimeMillis();

    @Test
    public void testCreatePersonalChat() {
        int case_id = 1188419;
        JsonObject response_personal_chat_create = app.chat().personalChatCreate(local_id, account);
        int status_cod = response_personal_chat_create.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Личный част успешно создан");
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
            app.testrail().setResultCase(case_id, "passed", "Личный част успешно удален");
        } else {
            Assert.fail("Personal chat not removed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Личный чат не удален, код ответ " + status_cod);
        }
    }
}
