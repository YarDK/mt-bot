import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactPersonalTests extends TestBase {

    private String id;

    @BeforeClass
    public void testPersonalContactAdd() {
        // Добавление
        JsonObject json_personal_add = app.contact().personalContactAdd();
        id = json_personal_add.getAsJsonObject("data").get("id").getAsString();
        Assert.assertEquals(
                json_personal_add.get("statusCode").getAsInt(),
                200,
                "Contact add failed, result not 200");
    }

    @Test
    public void testPersonalContactUpdate() {
        // обновление
        JsonObject json_personal_update = app.contact().personalContactUpdate(id);
        Assert.assertEquals(
                json_personal_update.get("statusCode").getAsInt(),
                200,
                "Contact update failed, result not 200");
    }

    @AfterClass
    public void testPersonalContactRemove() {
        // Удаление
        JsonObject json_personal_remove = app.contact().personalContactRemove(id);
        Assert.assertEquals(
                json_personal_remove.get("statusCode").getAsInt(),
                200,
                "Contact update failed, result not 200");
    }
}
