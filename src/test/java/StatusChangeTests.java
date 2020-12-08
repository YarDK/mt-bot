import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusChangeTests extends TestBase {

    @Test
    public void testChangStatusAway(){
        int case_id = 1188428;
        JsonObject response_change_status_away = app.profile().statusAway();
        int status_cod = response_change_status_away.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Статус Отошел выставлен успешно");
        } else {
            Assert.fail("Status away not set, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Статус не обновлен, код ответ " + status_cod);
        }
    }

    @Test(priority = 1)
    public void testChangStatusDND(){
        int case_id = 1188431;
        JsonObject response_change_status_dnd = app.profile()
                // previous status away or online
                .statusDND(app.timeStampToFinishDnd(15), "away");
        int status_cod = response_change_status_dnd.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Статус Не беспокоить выставлен успешно");
        } else {
            Assert.fail("Status DND not set, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Статус не обновлен, код ответ " + status_cod);
        }
    }

    @Test(priority = 2)
    public void testChangStatusOnline(){
        int case_id = 1188434;
        JsonObject response_change_status_online = app.profile().statusOnline();
        int status_cod = response_change_status_online.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Статус В сети выставлен успешно");
        } else {
            Assert.fail("Status Online not set, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Статус не обновлен, код ответ " + status_cod);
        }
    }
}
