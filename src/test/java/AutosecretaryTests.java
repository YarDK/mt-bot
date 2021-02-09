import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutosecretaryTests extends TestBase{

    static int rule_id;
    // Добавить в тестрейил кейсы

    @BeforeClass
    public void testAddRule(){
        int case_id = 0;
        JsonObject response_autosecretary_add =  app.autosecretary().add();

        int status_cod = response_autosecretary_add.get("statusCode").getAsInt();
        rule_id = response_autosecretary_add.get("data").getAsJsonObject().get("rule").getAsJsonObject().get("rule_id").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Новое правило автосекретаря добавлено");
        } else {
            Assert.fail("Status away not set, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Новое правило автосекретаря не добавлено, код ответа " + status_cod);
        }
    }


    @Test
    public void testGetRules(){
        int case_id = 0;
        JsonObject response_autosecretary_get =  app.autosecretary().get();
        int status_cod = response_autosecretary_get.get("statusCode").getAsInt();
        System.out.println("status_cod:\n" + status_cod);
    }


    @Test
    public void testUpdateRule(){
        int case_id = 0;
        JsonObject response_autosecretary_update=  app.autosecretary().update(rule_id);
        int status_cod = response_autosecretary_update.get("statusCode").getAsInt();
        System.out.println("status_cod:\n" + status_cod);
    }

    @AfterClass
    public void testDelRule(){
        int case_id = 0;
        JsonObject response_autosecretary_del=  app.autosecretary().del(rule_id);
        int status_cod = response_autosecretary_del.get("statusCode").getAsInt();
        System.out.println("status_cod:\n" + status_cod);
    }

}
