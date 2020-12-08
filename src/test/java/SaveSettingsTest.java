import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveSettingsTest extends TestBase{

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
}
