import Models.TestrailData;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJustTest extends TestBase{

    /*

Case(id=1169024, title=первый кейс секции, sectionId=174209, typeId=7, priorityId=2, milestoneId=null, refs=null, createdBy=15, createdOn=Wed Dec 02 18:10:27 MSK 2020, updatedBy=15, updatedOn=Wed Dec 02 18:10:27 MSK 2020, estimate=null, estimateForecast=null, suiteId=6026, customFields={automation_type=0, preconds=null, expected=null, steps_separated=null, steps=null, tags=null, goals=null})
Case(id=1187825, title=Новый тес ткейс проверки чего-нибудь, sectionId=174209, typeId=7, priorityId=2, milestoneId=null, refs=null, createdBy=15, createdOn=Sun Dec 06 21:18:04 MSK 2020, updatedBy=15, updatedOn=Sun Dec 06 21:18:04 MSK 2020, estimate=null, estimateForecast=null, suiteId=6026, customFields={automation_type=null, preconds=null, expected=null, steps_separated=null, steps=null, tags=null, goals=null})
Case(id=1169021, title=второй кейс подсекции, sectionId=174212, typeId=7, priorityId=2, milestoneId=null, refs=null, createdBy=15, createdOn=Wed Dec 02 18:10:16 MSK 2020, updatedBy=15, updatedOn=Wed Dec 02 18:10:16 MSK 2020, estimate=null, estimateForecast=null, suiteId=6026, customFields={automation_type=0, preconds=null, expected=null, steps_separated=null, steps=null, tags=null, goals=null})

     */

    @Test
    public void testTest1(){
        int case_id = 0;
        JsonObject response_product_get_melodies = app.autosecretary().getMelodies();
        JsonObject response_product_get_groups = app.autosecretary().getGroups();

        System.out.println("++++++++\n" + response_product_get_groups + "\n+++++++++\n" + response_product_get_melodies);
    }

}
