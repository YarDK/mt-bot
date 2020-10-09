import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusChangeTests extends TestBase {

    @Test
    public void testChangStatusAway(){
        JsonObject response_change_status_away = app.profile().statusAway();
        Assert.assertEquals(
                response_change_status_away.get("statusCode").getAsInt(),
                200,
                "Status away not set, result not 200");
    }

    @Test(priority = 1)
    public void testChangStatusDND(){
        JsonObject response_change_status_dnd = app.profile()
                // previous status away or online
                .statusDND(app.timeStampToFinishDnd(15), "away");

        Assert.assertEquals(
                response_change_status_dnd.get("statusCode").getAsInt(),
                200,
                "Status DND not set, result not 200");
    }

    @Test(priority = 2)
    public void testChangStatusOnline(){
        JsonObject response_change_status_online = app.profile().statusOnline();
        Assert.assertEquals(
                response_change_status_online.get("statusCode").getAsInt(),
                200,
                "Status Online not set, result not 200");
    }
}
