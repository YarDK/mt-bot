import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTests extends TestBase{

    @Test
    public void testRosterEdit() {
        // Добавить и убрать из избранных
        int case_id = 1404296;
        String vcard_iterate = app.execute_data().getVcards().iterator().next();
        String account = JsonParser.parseString(vcard_iterate).getAsJsonObject().get("account").getAsString();


        // Добавить
        JsonObject response_pin = app.contact().rosterEdit(account, true);
        int status_cod_pin = response_pin.get("statusCode").getAsInt();

        if(status_cod_pin == 200){
            app.testrail().setResultCase(case_id, "passed", "Контакт успешно добавлен в избранное");
        } else {
            Assert.fail("Contact update failed, result not 200");
            app.testrail().setResultCase(case_id,
                    "failed",
                    "Не удалось добавить контакт в избранное, код ответа " + status_cod_pin);
        }

        app.waiter(500);

        // Убрать
        JsonObject response_unpin = app.contact().rosterEdit(account, false);
        int status_cod_unpin = response_unpin.get("statusCode").getAsInt();

        if(status_cod_unpin == 200){
            app.testrail().setResultCase(case_id, "passed", "Контакт успешно убран из избранных");
        } else {
            Assert.fail("Contact update failed, result not 200");
            app.testrail().setResultCase(case_id,
                    "failed",
                    "Не удалось убрать контакт из избранных, код ответа " + status_cod_unpin);
        }

    }
}
