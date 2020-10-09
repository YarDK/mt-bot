import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactAbTests extends TestBase{

    private String contact_name;
    private long product_id;
    private String contact_id;
    private String phone_id;

    @BeforeClass
    public void CreateContactAb(){
        // Создание контакта
        JsonObject contact_add_response = app.contact().addressBookAdd();
        Assert.assertEquals(
                contact_add_response.getAsJsonArray("result").get(0).getAsJsonObject().get("code").getAsInt(),
                1000,
                "Contact add failed, result not 1000");

        contact_name = contact_add_response.getAsJsonObject("data").entrySet().iterator().next().getValue()
                .getAsJsonObject().get("name").getAsString();

        product_id = contact_add_response.getAsJsonObject("data").entrySet().iterator().next().getValue()
                .getAsJsonObject().getAsJsonObject("source_id").get("product_id").getAsLong();

        contact_id = contact_add_response.getAsJsonObject("data").entrySet().iterator().next().getKey();

        phone_id = contact_add_response.getAsJsonObject("data").entrySet().iterator().next().getValue()
                .getAsJsonObject().getAsJsonArray("phones").get(0).getAsJsonObject().get("phone_id").getAsString();
    }

    @Test
    public void testUpdateContact(){
        JsonObject contact_update_response = app.contact().addressBookUpdate(product_id,contact_id, contact_name, phone_id);
        Assert.assertEquals(
                contact_update_response.getAsJsonArray("result").get(0).getAsJsonObject().get("code").getAsInt(),
                1000,
                "Contact update failed, result not 1000");

        JsonObject contact_get_response = app.contact().addressBookGetContact(product_id, contact_id);
        Assert.assertEquals(
                contact_get_response.getAsJsonObject("result").get("code").getAsInt(),
                1000,
                "Contact get failed, result not 1000");
    }

    @Test(enabled = false)
    public void testGetContactAb(){
        JsonObject contact_get_response = app.contact().addressBookGetContact(400062183, "56584860");
        Assert.assertEquals(
                contact_get_response.getAsJsonObject("result").get("code").getAsInt(),
                1000,
                "Contact get failed, result not 1000");
    }

    @AfterClass
    public void testRemoveContact(){
        JsonObject contact_remove_response = app.contact().addressBookRemove(product_id, contact_id);
        Assert.assertEquals(
                contact_remove_response.getAsJsonArray("result").get(0).getAsJsonObject().get("code").getAsInt(),
                1000,
                "Contact remove failed, result not 1000");

        app.waiter(1000); // Ждем 3 сек, что бы в БД успела обновиться информация

        JsonObject contact_get_response = app.contact().addressBookGetContact(product_id, contact_id);
        Assert.assertEquals(
                contact_get_response.getAsJsonObject("result").get("code").getAsInt(),
                3500,
                "Contact not deleted");
    }
}
