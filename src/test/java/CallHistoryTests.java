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
}
