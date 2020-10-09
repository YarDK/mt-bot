import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactAdd extends TestBase{

    @Test
    public void testContactAdd(){
        // Создание контакта
        JsonObject contact_add_response = app.contact().addressBookAdd();
        Assert.assertEquals(
                contact_add_response.getAsJsonArray("result").get(0).getAsJsonObject().get("code").getAsInt(),
                1000,
                "Contact add failed, result not 1000");

        String contact_name = contact_add_response.getAsJsonObject("data")
                .entrySet().iterator().next().getValue().getAsJsonObject().get("name").getAsString();

        System.out.println("contact_name:\n" + contact_name);
        // Поиск созданного контакта по имени
        JsonObject contact_query_response = app.contact().addressBookQuery(contact_name);
        Assert.assertEquals(
                contact_query_response.getAsJsonObject().get("result").getAsJsonObject().get("code").getAsInt(),
                1000,
                "Contact add failed, result not 1000");
    }
}
