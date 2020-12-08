import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactPersonalTests extends TestBase {

    private String id;

    @BeforeClass
    public void testPersonalContactAdd() {
        // Добавление
        int case_id = 1188398;
        JsonObject json_personal_add = app.contact().personalContactAdd();
        int status_cod = json_personal_add.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Контакт успешно добавлен");
            id = json_personal_add.getAsJsonObject("data").get("id").getAsString();
        } else {
            Assert.fail("Contact add failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Контакт не добавлен, код ответ " + status_cod);
        }
    }

    @Test
    public void testPersonalContactUpdate() {
        // обновление
        int case_id = 1188401;
        JsonObject json_personal_update = app.contact().personalContactUpdate(id);
        int status_cod = json_personal_update.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Контакт успешно изменен");
        } else {
            Assert.fail("Contact update failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Контакт не изменен, код ответ " + status_cod);
        }

    }

    @AfterClass
    public void testPersonalContactRemove() {
        // Удаление
        int case_id = 1188404;
        JsonObject json_personal_remove = app.contact().personalContactRemove(id);
        int status_cod = json_personal_remove.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Контакт успешно удален");
        } else {
            Assert.fail("Contact remove failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Контакт не удален, код ответ " + status_cod);
        }
    }
}
