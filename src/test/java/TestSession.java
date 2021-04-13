import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.response.Response;
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

    @Test (enabled = false)
    public void testStatsGetData(){
        System.out.println("\n#####\nВывод StatsGetData");
        JsonObject response_stats_get_data = app.session().statsGetData();
        JsonObject response_stats_get_launches = app.session().statsGetLaunches();
    }

    @Test
    public void testFeatureGetForProduct(){
        int case_id = 0;

        JsonObject response = app.session().featureGetForProduct(app.data().getProduct_id());
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Функции приложения запрошены успешно");
        } else {
            Assert.fail("FeatureGetForProduct failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Функции приложения не запрошены, код ответ " + status_cod
            );
        }
    }

    @Test
    public void testAppLaunch(){
        int case_id = 0;

        String deviceId= app.data().getDevice_id();
        String deviceName= app.data().getDevice_name();
        String os= app.data().getOs();

        JsonObject response = app.session().appLaunch(deviceId, deviceName, os);
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Уведомление о запуске приложения устройством успешно");
        } else {
            Assert.fail("AppLaunch failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Уведомление о запуске приложения устройством не успешно, код ответ " + status_cod
            );
        }
    }

    @Test (enabled = false)
    public void testLogOut(){
        int case_id = 0;

        JsonObject response = app.session().logOut();
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "LogOut успешный");
        } else {
            Assert.fail("LogOut failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "LogOut не успешный, код ответ " + status_cod
            );
        }
    }

    @Test
    public void testIsServiceEnabled(){
        int case_id = 0;

        String service_code = "CALLS_REC";

        JsonObject response = app.session().isServiceEnabled(service_code);
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Запрос доступности улсгуи '"+service_code+"' успешный");
        } else {
            Assert.fail("IsServiceEnabled failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Запрос доступности улсгуи '"+service_code+"' не успешный, код ответа " + status_cod
            );
        }
    }

    @Test
    public void testServerTime(){
        int case_id = 0;

        Response response = app.session().serverTime();
        int status_cod = response.getStatusCode();
        long data = JsonParser.parseString(response.asString()).getAsJsonObject().get("data").getAsLong();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Серверное время получено успешно: " + data);
        } else {
            Assert.fail("IsServiceEnabled failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Серверное время запросить не удалось, код ответа " + status_cod
            );
        }
    }

    @Test
    public void testCheck(){
        int case_id = 0;

        JsonObject response = app.session().check(app.data().getAuth_token());
        int status_cod = response.get("result").getAsInt();

        if(status_cod == 1000){
            app.testrail().setResultCase(case_id, "passed", "Check успешный. Данные:\n" + response);
        } else {
            Assert.fail("Check failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Check не успешный, код ответ " + status_cod
            );
        }
    }

    @Test
    public void testPollEvents(){
        int case_id = 0;

        JsonObject response = app.session().pollEvents(app.data().getLastSid());
        int status_cod = response.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "PollEvents успешный.");
        } else {
            Assert.fail("PollEvents failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "PollEvents не успешный, код ответ " + status_cod
            );
        }
    }



}
