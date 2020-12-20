package OtherTest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testtest {

    @Test
    public void testTeset(){
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
}
