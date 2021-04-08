package OtherTest;

import Models.RegisterData;
import com.google.gson.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
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
    public void get_response(){
        String avatar_id = "5e49b4d6b7ef188c9459c587818130c97bafbb2aca93023daa6524fb6ca5b87ec3967d7be5f99760491a4c962f0e1efa1bd8f8b461c79fbb975f3376c98656f420cf38724a5459e6";
        String url = "https://chatfs.mango-office.ru/avatars/" + avatar_id;
        System.out.println(url);
        Response get_request = RestAssured.given()
                //.queryParam("","")
                .when().get(url);

        try{
            File outputFile = new File("src/test/resources/outputFile.jpg");
            outputFile.createNewFile();

            Files.write(outputFile.toPath(), get_request.body().asByteArray());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
