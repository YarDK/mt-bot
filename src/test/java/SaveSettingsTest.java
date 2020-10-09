import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveSettingsTest extends TestBase{

    @Test
    public void testSaveSettings(){
        JsonObject response_save_settings = app.profile()
                .saveSettings(app.data().getNumber(), app.data().getNumber_id(), app.data().getProtocol());

        Assert.assertEquals(
                response_save_settings.get("statusCode").getAsInt(),
                200,
                "Settings not saved, result not 200");
    }
}
