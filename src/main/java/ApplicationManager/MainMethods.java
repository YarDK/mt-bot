package ApplicationManager;

import Models.RegisterData;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MainMethods {

    public void waiter(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод возвращается timestamp до которого должен быть включен статус "Не беспокоить"
    public long timeStampToFinishDnd(long dnd_in_minute) {
        int millisecond_in_minute = 60000;
        long minute_to_millisecond = dnd_in_minute * millisecond_in_minute;
        Date date_now = new Date();
        Date date_to_finish_dnd = new Date(date_now.getTime() + minute_to_millisecond);
        System.out.println("\nTime to finish DND: " + date_to_finish_dnd + "\n");
        return date_to_finish_dnd.getTime();
    }

    public Set<String> getSid(JsonObject response_calls_recent) {
        Set<String> sid_list = new HashSet<>();
        JsonArray history_arr = response_calls_recent.getAsJsonObject("data").getAsJsonArray("history");
        for (JsonElement j : history_arr) {
            sid_list.add(j.getAsJsonObject().get("sid").getAsString());
        }
        return sid_list;
    }

    public String getJson(String file_path) {

        File json_file = new File(file_path);
        try {
            return JsonParser.parseReader(new JsonReader(new FileReader(json_file))).getAsJsonObject().toString();
        } catch (FileNotFoundException e) {
            System.out.println("File '" + file_path + "' not found");
            e.printStackTrace();
            return null;
        }
    }

    // Для работы с 4talk сервером
    public JsonObject post_response(String json, String url, RegisterData data) {
        System.out.println("\nJson for " + url + ":\n" + json);

        String post_request = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json)
                .post(data.getUrl_4talk() + url).asString();


        System.out.println("\nResponse for " + url + ":\n" + post_request);
        try {
            return JsonParser.parseString(post_request).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            JsonObject err_json = new JsonObject();
            err_json.addProperty("response", post_request);
            return err_json;
        }
    }

    // Общий метод для работы с авторизованными запросами
    public JsonObject post_response(String json, String url, RegisterData data, Boolean not_4talk) {
        System.out.println("\nJson for " + url + ":\n" + json);

        String post_request;
        if (not_4talk) {
            post_request = RestAssured.given()
                    .header("X-AUTH-TOKEN", data.getAuth_token())
                    .contentType(ContentType.JSON)
                    .body(json)
                    .post(url).asString();

            System.out.println("\nResponse for " + url + ":\n" + post_request);
        } else {
            post_request = "";
            System.out.println("\nWrong\nUse post_response function with flag 'not_4talk=true'");
        }

        try {
            return JsonParser.parseString(post_request).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            JsonObject err_json = new JsonObject();
            err_json.addProperty("response", post_request);
            return err_json;
        }
    }


    public Response get_response(String url) {
        Response get_request = RestAssured.get(url);
        System.out.println("\nResponse cod for " + url + ":\n" + get_request.getStatusCode());
        // Обработка индивидуальна со стороны заправшиваемого метода
        //get_request.body().print()
        //get_request.asString()
        //get_request.getStatusCode()
        return get_request;
    }


}
