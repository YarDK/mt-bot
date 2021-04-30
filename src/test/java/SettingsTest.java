import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTest extends TestBase{

    @Test
    public void testSaveSettings(){
        int case_id = 1188425;
        JsonObject response_save_settings = app.profile()
                .saveSettings(app.data().getNumber(), app.data().getNumber_id(), app.data().getProtocol());
        int status_cod = response_save_settings.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Настройки обнволены");
        } else {
            Assert.fail("Settings not saved, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Настройки не обновлены, код ответ " + status_cod);
        }

    }

    @Test
    public void testSettingsGet(){
        int case_id = 1404350;

        JsonObject response = app.profile().settingsGet();
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Настройки получены");
        } else {
            Assert.fail("SettingsGet failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Настройки не получены, код ответ " + status_cod);
        }

    }

    @Test
    public void testSettingsSave(){
        int case_id = 1405073;

        JsonObject response = app.profile().settingsSave();
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Настройки сохранены");
        } else {
            Assert.fail("SettingsSave failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Настройки не сохранены, код ответ " + status_cod);
        }
    }

    @Test
    public void testSetWorkingHours(){
        int case_id = 1405076;

        JsonObject response_on = app.profile().setWorkingHours(true);
        int status_cod_on = response_on.get("statusCode").getAsInt();

        if(status_cod_on == 200){
            app.testrail().setResultCase(case_id, "passed", "Расписание включено");
        } else {
            Assert.fail("SetWorkingHours ON failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Расписание не удалось включить, код ответ " + status_cod_on);
        }

        app.waiter(1000);

        JsonObject response_off = app.profile().setWorkingHours(false);
        int status_cod_off = response_off.get("statusCode").getAsInt();

        if(status_cod_off == 200){
            app.testrail().setResultCase(case_id, "passed", "Расписание выключено");
        } else {
            Assert.fail("SetWorkingHours OFF failed, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Расписание не удалось выключить, код ответ " + status_cod_off);
        }
    }

    @Test
    public void testNotificationsUpdate(){
        int case_id = 1405079;

        JsonObject response = app.profile().notificationsUpdate();
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Настройка email уведомлений включена");
        } else {
            Assert.fail("NotificationsUpdate failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Настройку email уведомления не удалось включить, код ответ " + status_cod
            );
        }
    }



    @Test
    public void testNotificationsGet(){
        int case_id = 1405082;

        JsonObject response = app.profile().notificationsGet();
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Настройки email уведомлений получены");
        } else {
            Assert.fail("NotificationsGet failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Настройки email уведомлений не удалось включить, код ответ " + status_cod
            );
        }
    }


}
