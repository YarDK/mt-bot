import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CallHistoryTests extends TestBase {


    @Test
    public void testGetRecord() {
        int case_id = 1169024;
        JsonObject response_calls_recent = app.callHistory().callsRecent();

        for (String sid : app.getSid(response_calls_recent)) {
            JsonObject response_get_record = app.callHistory().getRecordLink(sid);
            int status_code = response_get_record.get("statusCode").getAsInt();

                // Сид сущесвует, но запись не найдена
            if (status_code == 1013)
            {
                String record_not_found = String.format("Record for sid '%s' not found", sid);
                System.out.println(record_not_found);
                app.testrail().setResultCase(case_id, "retest", record_not_found);

                // Любой другой код ответа, отличный от успешного
            } else if (status_code != 200)
            {
                app.testrail().setResultCase(case_id, "failed", "Record link not found and get");
                Assert.fail("Record link not found and get");

                // Запись успешно найдена
            } else
                {
                String passed_message = String.format("Record for sid '%s': ", sid) +
                        response_get_record.getAsJsonObject("data").get("url").getAsString();

                System.out.println(passed_message);
                app.testrail().setResultCase(case_id, "passed", passed_message);
            }

            //Assert.assertEquals(response_get_record.get("statusCode").getAsInt(),200,failed_message);
        }
    }

    @Test
    public void testCallsHistory(){
        int case_id = 0;

        String number = "74955404444";
        JsonObject response_calls_history = app.callHistory().callsHistory(number);
        int status_cod = response_calls_history.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "История звонокв по номеру " + number + " получена успешно");
        } else {
            Assert.fail("Calls history for number '"+number+"' not getting, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "История звонокв по номеру " + number + " не получена.\nКод ответа " + status_cod
            );
        }
    }

    @Test
    public void testCallsHistory_ref(){
        int case_id = 0;

        String number = "74955404444";
        JsonObject response_calls_history = app.callHistory().callsHistory_ref(number);
        int status_cod = response_calls_history.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "История звонокв по номеру " + number + " получена успешно");
        } else {
            Assert.fail("Calls history for number '"+number+"' not getting, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "История звонокв по номеру " + number + " не получена.\nКод ответа " + status_cod
            );
        }
    }

    @Test
    public void testCallsNotifyAnswered(){
        int case_id = 0;

        // Придумать откуда брать данные о звонке, сейча берутся статичные данные конткрентого звонка:
        String callId = "534344147";
        String contextId = "11136795356";

        JsonObject response_calls_notify_answered = app.callHistory().callsNotifyAnswered(callId,contextId);
        int status_cod = response_calls_notify_answered.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Уведомление об ответе на звонок отправлено успешно");
        } else {
            Assert.fail("Сalls notify answered not send, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Уведомление об ответе на звонок отправлено не успешно, код ответа " + status_cod
            );
        }
    }


    @Test
    public void testCallsNotifyStarted(){
        int case_id = 0;

        // Придумать откуда брать данные о звонке, сейча берутся статичные данные конткрентого звонка:
        String contextId = "11136781099";

        JsonObject response_calls_notify_started = app.callHistory().callsNotifyStarted(contextId);
        int status_cod = response_calls_notify_started.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Уведомление о начале звонка отправлено успешно");
        } else {
            Assert.fail("Сalls notify started not send, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Уведомление о начале звонка отправлено не успешно, код ответа " + status_cod
            );
        }
    }

    @Test
    public void testCallsSearch(){
        int case_id = 0;

        // Придумать откуда брать данные о звонке, сейча берутся статичные данные конткрентого звонка:
        String query = "test";

        JsonObject response_calls_search = app.callHistory().callsSearch(query);
        int status_cod = response_calls_search.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Поиск по '"+query+"' выполнен успешно.");
        } else {
            Assert.fail("Search query failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Поиск по '"+query+"' выполнен не успешно. Код ответа " + status_cod
            );
        }
    }

    @Test
    public void testCallsSync(){
        int case_id = 0;

        JsonObject response_calls_sync= app.callHistory().callsSync();
        int status_cod = response_calls_sync.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Синхронизация журнала звонков выполнена успешно.");
        } else {
            Assert.fail("CallsSync failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Синхронизация журнала звонков выполнена не кспешно с кодом " + status_cod
            );
        }
    }

    @Test
    public void testCallsGet(){
        int case_id = 0;

        JsonObject response_calls_get= app.callHistory().callsGet();
        int status_cod = response_calls_get.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Дозагрузка из журнала звонков выполнена успешно.");
        } else {
            Assert.fail("CallsGet failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Дозагрузка из журнала звонков выполнена не кспешно с кодом " + status_cod
            );
        }
    }


}
