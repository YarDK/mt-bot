import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutosecretaryTests extends TestBase{

    static int rule_id;
    static int melody_file_id;
    // Добавить в тестрейил кейсы

    @BeforeClass
    public void testAddRule(){
        int case_id = 1346876;
        JsonObject response_autosecretary_add =  app.autosecretary().add();

        int status_cod = response_autosecretary_add.get("statusCode").getAsInt();
        rule_id = response_autosecretary_add.get("data").getAsJsonObject().get("rule").getAsJsonObject().get("rule_id").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Новое правило автосекретаря добавлено");
        } else {
            Assert.fail("New rule not added, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Новое правило автосекретаря не добавлено, код ответа " + status_cod);
        }
    }


    @Test
    public void testGetRules(){
        int case_id = 1346882;
        JsonObject response_autosecretary_get =  app.autosecretary().get();
        int status_cod = response_autosecretary_get.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Запрос правил успешный");
        } else {
            Assert.fail("Groups not get, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Запрос правил не успешный, код ответа " + status_cod);
        }
    }


    @Test
    public void testUpdateRule(){
        int case_id = 1346885;
        JsonObject response_autosecretary_update=  app.autosecretary().update(rule_id);
        int status_cod = response_autosecretary_update.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Обновление правила успешно");
        } else {
            Assert.fail("Rule not update, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Обновление правил не успешно, код ответа " + status_cod);
        }
    }

    @Test
    public void testGetMelodies(){
        int case_id = 1346879;
        JsonObject response_product_get_melodies = app.autosecretary().getMelodies();

        // Достаем одну мелодию для дальнейшего прохождения кейсов
        JsonArray melodies_json_arr = response_product_get_melodies
                .getAsJsonObject("data")
                .getAsJsonArray("melodies");

        // ID мелодии берется из середины списка
        int melodies_count = melodies_json_arr.size();
        melody_file_id = melodies_json_arr.get(melodies_count/2).getAsJsonObject().get("melody_id").getAsInt();

        int status_cod = response_product_get_melodies.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Список мелодий успешно получен");
        } else {
            Assert.fail("Melodies list not getting, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Список мелодий не получен, код ответа " + status_cod);
        }
    }

    @Test
    public void testGetGroups(){
        int case_id = 1346888;
        JsonObject response_product_get_groups = app.autosecretary().getGroups();

        int status_cod = response_product_get_groups.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Список групп успешно получен");
        } else {
            Assert.fail("Groups list not getting, result not 200");
            app.testrail().setResultCase(case_id, "failed", "Список групп не получен, код ответа " + status_cod);
        }
    }

    @Test(priority = 1)
    public void testGetFile(){
        int case_id = 1346891;
        JsonObject response_autosecretary_get_file =  app.autosecretary().getFile(melody_file_id);
        int status_cod = response_autosecretary_get_file.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Файл успешно получен");
        } else {
            Assert.fail("GetFile result not 200");
            app.testrail().setResultCase(case_id, "failed", "Файл не получен, код ответа " + status_cod);
        }
    }

    @AfterClass
    public void testDelRule(){
        int case_id = 1346894;
        JsonObject response_autosecretary_del=  app.autosecretary().del(rule_id);
        int status_cod = response_autosecretary_del.get("statusCode").getAsInt();

        if(status_cod == 200){
            app.testrail().setResultCase(case_id, "passed", "Правило успешно удалено");
        } else {
            Assert.fail("GetFile result not 200");
            app.testrail().setResultCase(case_id, "failed", "Правило не удалено, код ответа " + status_cod);
        }
    }

}
