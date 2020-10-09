import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CallHistoryTests extends TestBase{

    @Test
    public void testGetRecord(){
        JsonObject response_calls_recent =  app.callHistory().callsRecent();

        for(String sid : app.getSid(response_calls_recent)){
            JsonObject response_get_record = app.callHistory().getRecordLink(sid);
            if(response_get_record.get("statusCode").getAsInt() == 1013){
                System.out.println(String.format("Record for sid '%s' not found", sid));
            } else {
                Assert.assertEquals(
                        response_get_record.get("statusCode").getAsInt(),
                        200,
                        "Record ling not found and get");
                System.out.print(String.format("Record for sid '%s': ", sid));
                System.out.println(response_get_record.getAsJsonObject("data").get("url").getAsString());
            }
        }
    }
}
