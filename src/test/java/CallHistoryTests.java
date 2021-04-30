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
        int case_id = 1347005;

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
    public void testCallsNotifyAnswered(){
        int case_id = 1347053;

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
                    "Уведомление об ответе на звонок отправлено не успешно, код ответа " + status_cod +
                            "\nВозможна ошибка на стороны статичных данных, проверить наличие контекста " + contextId
            );
        }
    }


    @Test
    public void testCallsNotifyStarted(){
        int case_id = 1347056;

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
        int case_id = 1347059;

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
        int case_id = 1347062;

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

    @Test(enabled = false)
    public void testCallsRemove(){
        int case_id = 1347065;
        // Добавить sid звонка, надо как-то автоматизировать
        String sid = "";

        int status_cod = app.callHistory().callsRemove(sid).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Звонок успешно удален");
        } else {
            Assert.fail("CallsRemove failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Звонок не удалось удалить. Код ответа " + status_cod
            );
        }
    }

    @Test(enabled = false)
    public void testCallsRemoveAll(){
        int case_id = 1347065;
        // Добавить sid звонка, до которого надо удалить все записи
        String sid = "";

        int status_cod = app.callHistory().callsRemoveAll(sid).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Звоноки успешно удалены");
        } else {
            Assert.fail("CallsRemoveAll failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Звоноки не удалось удалить. Код ответа " + status_cod
            );
        }
    }

    @Test
    public void callsResetMissedCount(){
        int case_id = 1347071;
        // Добавить sid звонка, надо как-то автоматизировать
        String sid = "417519551034404480";

        int status_cod = app.callHistory().callsResetMissedCount(sid).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Счетчик пропущенных вызовов сброшен успешно.");
        } else {
            Assert.fail("Reset Missed Count failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Счетчик сбросить не удалось. Код ответа " + status_cod
            );
        }
    }

    @Test
    public void testCallsSetOutgoingLine(){
        int case_id = 1347074;
        String account = app.data().getAccount();
        String outgoingline = "74951203279";

        int status_cod = app.callHistory().callsSetOutgoingLine(account, outgoingline).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(
                    case_id,
                    "passed",
                    "Номер '"+outgoingline+"' успешно установлен для аккаунт "+account
            );
        } else {
            Assert.fail("Calls Set Outgoing Line failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Не удалось установить номер исходящей связи '"+outgoingline+"'. Код ответа " + status_cod
            );
        }
    }

    @Test(enabled = false)
    public void testCallsNotesSave(){
        int case_id = 1404269;
        String sid = "417519551034404480";

        int status_cod = app.callHistory().callsNotesSave(sid).get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Заметка для звонка успешно установлена.");
        } else {
            Assert.fail("CallsGet failed, result not 200");
            app.testrail().setResultCase(
                    case_id,
                    "failed",
                    "Заметка для звонка не установлена. Код ответа " + status_cod
            );
        }
    }


}
