package OtherTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testtest {

    @Test(enabled = false)
    public void testTest1(){
        String field_step = "[Field.Step(content={\"JSON_ATREBUTE\":\"JOSN_PARAM\"}, expected={\"result\":200})]";
        String field_step_2 = "[Field.Step(content={\"JSON_ATREBUTE\":\"JOSN_PARAM\"}, expected={\"result\":200}), Field.Step(content={\"BUNY_JSON_ATREBUTE\":\"JOSN_PARAM\", \"BUNY_JSON_ATREBUTE\":\"JOSN_PARAM\"}, expected={\"result\":1000})]";

        // [(].*[)] - что бы взять скобки
        // [^=]\d.*[^\D] - что бы взять Код ответа в ожидаемом результате
        // [{].*[}]
        // [c].*[}] - текст внутри скобок

        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(field_step_2);
        List<String> matcher_list = new ArrayList<>();

        while (matcher.find()) {
            matcher_list.add(field_step_2.substring(matcher.start(), matcher.end()));
        }

        for(int i=0; i < matcher_list.size(); i=i+2){
            System.out.println("Используемый JSON: " + matcher_list.get(i));
            System.out.println("Ожидаемый ответ от сервера: " + matcher_list.get(i+1));
        }

    }

    @Test
    public void test2(){
        String json = "{\"status\":\"ok\",\"statusCode\":200,\"data\":{\"melodies\":[{\"melody_id\":17,\"name\":\"Abandoned\",\"file_id\":17},{\"melody_id\":1000008022,\"name\":\"test-sas\",\"file_id\":1000008022},{\"melody_id\":1000008023,\"name\":\"test-sas2\",\"file_id\":1000008023},{\"melody_id\":1000007835,\"name\":\"111Test\",\"file_id\":1000007835},{\"melody_id\":1000007836,\"name\":\"000123\",\"file_id\":1000007836},{\"melody_id\":61,\"name\":\"Era Ameno\",\"file_id\":61},{\"melody_id\":1000009832,\"name\":\"ЯЯЯЯЯЯ226yyy\",\"file_id\":1000009832},{\"melody_id\":48,\"name\":\"Metric trend\",\"file_id\":48},{\"melody_id\":1000010446,\"name\":\"upload_from_MM_to_new_vpbx_fs\",\"file_id\":1000010446},{\"melody_id\":1000010454,\"name\":\"айуцайцуа\",\"file_id\":1000010454},{\"melody_id\":1000010455,\"name\":\"300013073\",\"file_id\":1000010455},{\"melody_id\":1000010591,\"name\":\"standard\",\"file_id\":1000010591},{\"melody_id\":21,\"name\":\"Evil Deed\",\"file_id\":21},{\"melody_id\":27,\"name\":\"Far from home\",\"file_id\":27},{\"melody_id\":64,\"name\":\"Paul Mauriat Parapuies De Cherburg\",\"file_id\":64},{\"melody_id\":53,\"name\":\"Чайковский Вальс цветов\",\"file_id\":53},{\"melody_id\":26,\"name\":\"From the heavens\",\"file_id\":26},{\"melody_id\":49,\"name\":\"Honor\",\"file_id\":49},{\"melody_id\":25,\"name\":\"KickIt\",\"file_id\":25},{\"melody_id\":97,\"name\":\"Krokus\",\"file_id\":97},{\"melody_id\":30,\"name\":\"La Cha Cha\",\"file_id\":30},{\"melody_id\":29,\"name\":\"La Neige Dantans\",\"file_id\":29},{\"melody_id\":62,\"name\":\"Lemar Lemar If theres any justice\",\"file_id\":62},{\"melody_id\":15,\"name\":\"LoveIs blue\",\"file_id\":15},{\"melody_id\":28,\"name\":\"Made the grade\",\"file_id\":28},{\"melody_id\":33,\"name\":\"Milagro\",\"file_id\":33},{\"melody_id\":14,\"name\":\"Сиртаки\",\"file_id\":14},{\"melody_id\":1,\"name\":\"abba\",\"file_id\":1},{\"melody_id\":32,\"name\":\"Quest\",\"file_id\":32},{\"melody_id\":8,\"name\":\"REM\",\"file_id\":8},{\"melody_id\":31,\"name\":\"Red sky\",\"file_id\":31},{\"melody_id\":47,\"name\":\"Rise and shine\",\"file_id\":47},{\"melody_id\":36,\"name\":\"Romantic nights\",\"file_id\":36},{\"melody_id\":35,\"name\":\"Running\",\"file_id\":35},{\"melody_id\":34,\"name\":\"Spain\",\"file_id\":34},{\"melody_id\":46,\"name\":\"Strong survive the\",\"file_id\":46},{\"melody_id\":40,\"name\":\"Take me higher\",\"file_id\":40},{\"melody_id\":38,\"name\":\"The crying machine\",\"file_id\":38},{\"melody_id\":51,\"name\":\"The opening\",\"file_id\":51},{\"melody_id\":92,\"name\":\"marry christmas\",\"file_id\":92},{\"melody_id\":88,\"name\":\"new year mix\",\"file_id\":88},{\"melody_id\":330031780,\"name\":\"password_greeting\",\"file_id\":330031780},{\"melody_id\":10,\"name\":\"sting\",\"file_id\":10},{\"melody_id\":11,\"name\":\"ub40\",\"file_id\":11},{\"melody_id\":9,\"name\":\"wonder\",\"file_id\":9},{\"melody_id\":330055363,\"name\":\"Абонент не отвечает или временно недоступен\",\"file_id\":330055363},{\"melody_id\":3,\"name\":\"Бетховен\",\"file_id\":3},{\"melody_id\":90,\"name\":\"В лесу родилась елочка\",\"file_id\":90},{\"melody_id\":42,\"name\":\"Вертикаль\",\"file_id\":42},{\"melody_id\":7,\"name\":\"Грибоедов\",\"file_id\":7},{\"melody_id\":96,\"name\":\"Гудок\",\"file_id\":96},{\"melody_id\":68,\"name\":\"Запрос пароля\",\"file_id\":68},{\"melody_id\":69,\"name\":\"К сожалению все операторы заняты\",\"file_id\":69},{\"melody_id\":52,\"name\":\"Катюша\",\"file_id\":52},{\"melody_id\":89,\"name\":\"Маленькой елочке холодно зимой\",\"file_id\":89},{\"melody_id\":67,\"name\":\"Оставьте ваше сообщение после сигнала\",\"file_id\":67},{\"melody_id\":555,\"name\":\"Техническая тишина (1 секунда)\",\"file_id\":555},{\"melody_id\":37,\"name\":\"Third floor lingerie\",\"file_id\":37},{\"melody_id\":65,\"name\":\"У природы нет плохой погоды\",\"file_id\":65},{\"melody_id\":1000010348,\"name\":\"!яяяяя-seaweed\",\"file_id\":1000010348},{\"melody_id\":1000010349,\"name\":\"!яаааа-seaweed2\",\"file_id\":1000010349},{\"melody_id\":1000010350,\"name\":\"Я555-seaweed5\",\"file_id\":1000010350},{\"melody_id\":45,\"name\":\"Can do\",\"file_id\":45},{\"melody_id\":63,\"name\":\"Vanessa Mae Classical Gas\",\"file_id\":63},{\"melody_id\":330048423,\"name\":\"TEST_DATA\",\"file_id\":330048423},{\"melody_id\":330191678,\"name\":\"TEST_DATA\",\"file_id\":330191678},{\"melody_id\":1000002105,\"name\":\"Тестовое имя новой мелодии 1486737805\",\"file_id\":1000002105},{\"melody_id\":1000002106,\"name\":\"Тестовое имя новой мелодии 1486976605\",\"file_id\":1000002106},{\"melody_id\":1000002107,\"name\":\"Тестовое имя новой мелодии 1486976701\",\"file_id\":1000002107},{\"melody_id\":1000002108,\"name\":\"Тестовое имя новой мелодии 1486976824\",\"file_id\":1000002108},{\"melody_id\":1000002111,\"name\":\"Тестовое имя новой мелодии 1487075863\",\"file_id\":1000002111},{\"melody_id\":1000002112,\"name\":\"Тестовое имя новой мелодии 1487076744\",\"file_id\":1000002112},{\"melody_id\":1000002113,\"name\":\"Тестовое имя новой мелодии 1487076794\",\"file_id\":1000002113},{\"melody_id\":1000002114,\"name\":\"Тестовое имя новой мелодии 1487080516\",\"file_id\":1000002114},{\"melody_id\":1000002115,\"name\":\"Тестовое имя новой мелодии 1487080566\",\"file_id\":1000002115},{\"melody_id\":1000002116,\"name\":\"Тестовое имя новой мелодии 1487080610\",\"file_id\":1000002116},{\"melody_id\":1000002117,\"name\":\"Введите цифры\",\"file_id\":1000002117},{\"melody_id\":1000002118,\"name\":\"Подождите завершения обработки\",\"file_id\":1000002118},{\"melody_id\":1000001708,\"name\":\"test-Kalimba2\",\"file_id\":1000001708},{\"melody_id\":1000001709,\"name\":\"test-sound\",\"file_id\":1000001709},{\"melody_id\":330201038,\"name\":\"TEST_DATA\",\"file_id\":330201038},{\"melody_id\":1000002104,\"name\":\"Тестовое имя новой мелодии\",\"file_id\":1000002104},{\"melody_id\":1000001687,\"name\":\"!del\",\"file_id\":1000001687},{\"melody_id\":1000001707,\"name\":\"test-Kalimba\",\"file_id\":1000001707},{\"melody_id\":1000002705,\"name\":\"123456789\",\"file_id\":1000002705},{\"melody_id\":1000003045,\"name\":\"Космос\",\"file_id\":1000003045},{\"melody_id\":86,\"name\":\"Abba Happy NY\",\"file_id\":86},{\"melody_id\":20,\"name\":\"Aisle 9 Please\",\"file_id\":20},{\"melody_id\":56,\"name\":\"Aventura Love Story\",\"file_id\":56},{\"melody_id\":57,\"name\":\"Bad boys blue Only one breath away\",\"file_id\":57},{\"melody_id\":58,\"name\":\"Blonker sidewalk cafe\",\"file_id\":58},{\"melody_id\":19,\"name\":\"Cacho Oro\",\"file_id\":19},{\"melody_id\":18,\"name\":\"Challenge\",\"file_id\":18},{\"melody_id\":44,\"name\":\"China wall\",\"file_id\":44},{\"melody_id\":43,\"name\":\"Companion\",\"file_id\":43},{\"melody_id\":24,\"name\":\"Dark Haze\",\"file_id\":24},{\"melody_id\":23,\"name\":\"Determined Tumbao\",\"file_id\":23},{\"melody_id\":22,\"name\":\"El Rey\",\"file_id\":22},{\"melody_id\":59,\"name\":\"Ennio Morricone Chi Mai\",\"file_id\":59},{\"melody_id\":60,\"name\":\"Ennio Morricone Once upon a time\",\"file_id\":60},{\"melody_id\":98,\"name\":\"Unity\",\"file_id\":98},{\"melody_id\":39,\"name\":\"Untameable fire\",\"file_id\":39},{\"melody_id\":66,\"name\":\"Vanessa Paradis Joe Le taxi\",\"file_id\":66},{\"melody_id\":330029509,\"name\":\"VoiceMail\",\"file_id\":330029509},{\"melody_id\":50,\"name\":\"Wings of the wind\",\"file_id\":50},{\"melody_id\":41,\"name\":\"Your eyes on glory\",\"file_id\":41},{\"melody_id\":2,\"name\":\"alphaville\",\"file_id\":2},{\"melody_id\":13,\"name\":\"amelie\",\"file_id\":13},{\"melody_id\":16,\"name\":\"av hold\",\"file_id\":16},{\"melody_id\":5,\"name\":\"direstraits\",\"file_id\":5},{\"melody_id\":4,\"name\":\"diva\",\"file_id\":4},{\"melody_id\":6,\"name\":\"eagles\",\"file_id\":6},{\"melody_id\":12,\"name\":\"jazz\",\"file_id\":12},{\"melody_id\":91,\"name\":\"jingle bells\",\"file_id\":91},{\"melody_id\":1000010707,\"name\":\"123333\",\"file_id\":1000010707},{\"melody_id\":1000003080,\"name\":\"123\",\"file_id\":1000003080},{\"melody_id\":1000011564,\"name\":\"Свежатинка\",\"file_id\":1000011564}]}}";
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonArray melodies_json_arr = jsonObject.getAsJsonObject("data").getAsJsonArray("melodies");
        for(JsonElement j : melodies_json_arr){
            //System.out.println(j.getAsJsonObject().get("melody_id").getAsString());
        }

        System.out.println(melodies_json_arr.get(117/2).getAsJsonObject().get("melody_id").getAsInt());

        //melodies.forEach(System.out::println);

    }
}
