import com.google.gson.JsonObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSession extends TestBase {

    @Test(enabled = false)
    public void testRegister(){
        System.out.println("TestRegister done!");
    }

    @Test(enabled = false)
    public void testRegisterEmail(){
        app.session().unregister();
        System.out.println("Wait 31 second...");
        app.waiter(31000);
        app.session().credentials();
        app.session().registration();
        System.out.println("TestRegister with Email done!");
    }

    @Test
    public void testStatsGetData(){
        System.out.println("\n#####\nВывод StatsGetData");
        JsonObject response_stats_get_data = app.session().statsGetData();
        JsonObject response_stats_get_launches = app.session().statsGetLaunches();
    }


}
