import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutosecretaryTests extends TestBase{

    @Test
    public void testAddRule(){
        int case_id = 0;
        JsonObject response_autosecretary_add =  app.autosecretary().add();

        int status_cod = response_autosecretary_add.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Новое правило автосекретаря добавлено");
        } else {
            Assert.fail("Status away not set, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Новое правило автосекретаря не добавлено, код ответа " + status_cod);
        }
    }
}
