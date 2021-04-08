package OtherTest;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.MultiPartSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import jsons.channel.JsonChannel;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

import static com.jayway.restassured.RestAssured.given;

public class TestJsonRead {


    @Test
    public void test4() {
        String json = "{\"status\":\"ok\",\"statusCode\":200,\"data\":{\"history\":[{\"type\":\"call\",\"outgoing\":true,\"stime\":1594293382000,\"sid\":\"412235106770649152\",\"account\":\"401530378@mtalker.mangotele.com\",\"payload\":{\"callEvents\":[{\"type\":\"outgoing\",\"ctx_seq\":1,\"timestamp\":1594293382,\"call_state\":\"Appeared\",\"call_id\":660745,\"context_id\":9317090255,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":2,\"timestamp\":1594293387,\"call_state\":\"Connected\",\"call_id\":660745,\"context_id\":9317090255,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":6,\"timestamp\":1594293410,\"call_state\":\"Disconnected\",\"disconnect_reason\":1110,\"call_id\":660745,\"context_id\":9317090255,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}}],\"callRecordAvailable\":true,\"wasMissedAndRecalled\":false,\"confEvents\":[{\"Event-Name\":\"on_call_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594293382,\"seq\":0,\"line\":\"\",\"direction\":\"in\",\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\",\"remote_party\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"abonent_id\":402012087,\"internal_number\":565},\"local_party\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870,\"abonent_id\":\"401530378\"}}},{\"Event-Name\":\"on_call_answer\",\"Content-Version\":null,\"Data\":{\"tm\":1594293387,\"seq\":5,\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_link_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594293387,\"seq\":7,\"link_id\":374940,\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_record_start\",\"Content-Version\":null,\"Data\":{\"tm\":1594293387,\"seq\":8,\"type\":\"order\",\"record_id\":\"NjYwNzM2OjA=\",\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_call_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293410,\"seq\":10,\"product_id\":400062183,\"destroy_reason\":{\"code\":1100},\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_link_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293410,\"seq\":11,\"link_id\":374940,\"product_id\":400062183,\"destroy_reason\":{\"code\":1110,\"call_initiator\":660736},\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_record_stop\",\"Content-Version\":null,\"Data\":{\"tm\":1594293410,\"seq\":12,\"type\":\"order\",\"record_id\":\"NjYwNzM2OjA=\",\"product_id\":400062183,\"stop_reason\":{\"code\":1000},\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}}],\"answeredByAccount\":\"401530378@mtalker.mangotele.com\"}},{\"type\":\"call\",\"outgoing\":true,\"stime\":1594292974000,\"sid\":\"412235001513818784\",\"account\":\"401530378@mtalker.mangotele.com\",\"payload\":{\"callEvents\":[{\"type\":\"outgoing\",\"ctx_seq\":1,\"timestamp\":1594292974,\"call_state\":\"Appeared\",\"call_id\":673128248,\"context_id\":9316993396,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":2,\"timestamp\":1594292976,\"call_state\":\"Connected\",\"call_id\":673128248,\"context_id\":9316993396,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":5,\"timestamp\":1594293002,\"call_state\":\"Disconnected\",\"disconnect_reason\":1120,\"call_id\":673128248,\"context_id\":9316993396,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}}],\"callRecordAvailable\":false,\"wasMissedAndRecalled\":false,\"confEvents\":[{\"Event-Name\":\"on_call_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292974,\"seq\":0,\"line\":\"\",\"direction\":\"in\",\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\",\"remote_party\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"abonent_id\":402012087,\"internal_number\":565},\"local_party\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870,\"abonent_id\":\"401530378\"}}},{\"Event-Name\":\"on_call_answer\",\"Content-Version\":null,\"Data\":{\"tm\":1594292976,\"seq\":5,\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_link_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292976,\"seq\":7,\"link_id\":1330534,\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_record_start\",\"Content-Version\":null,\"Data\":{\"tm\":1594292976,\"seq\":8,\"type\":\"order\",\"record_id\":\"NjczMTI4MjQwOjA=\",\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_link_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293002,\"seq\":11,\"link_id\":1330534,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120,\"call_initiator\":673128248},\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_call_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293002,\"seq\":13,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120},\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_record_stop\",\"Content-Version\":null,\"Data\":{\"tm\":1594293002,\"seq\":14,\"type\":\"order\",\"record_id\":\"NjczMTI4MjQwOjA=\",\"product_id\":400062183,\"stop_reason\":{\"code\":1000},\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}}],\"answeredByAccount\":\"401530378@mtalker.mangotele.com\"}},{\"type\":\"call\",\"outgoing\":true,\"stime\":1594292305000,\"sid\":\"412234830818858817\",\"account\":\"401530378@mtalker.mangotele.com\",\"payload\":{\"callEvents\":[{\"type\":\"outgoing\",\"ctx_seq\":1,\"timestamp\":1594292305,\"call_state\":\"Appeared\",\"call_id\":673114539,\"context_id\":9316833837,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":2,\"timestamp\":1594292320,\"call_state\":\"Connected\",\"call_id\":673114539,\"context_id\":9316833837,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":5,\"timestamp\":1594292330,\"call_state\":\"Disconnected\",\"disconnect_reason\":1120,\"call_id\":673114539,\"context_id\":9316833837,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}}],\"callRecordAvailable\":false,\"wasMissedAndRecalled\":false,\"confEvents\":[{\"Event-Name\":\"on_call_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292305,\"seq\":0,\"line\":\"\",\"direction\":\"in\",\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\",\"remote_party\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"abonent_id\":402012087,\"internal_number\":565},\"local_party\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870,\"abonent_id\":\"401530378\"}}},{\"Event-Name\":\"on_call_answer\",\"Content-Version\":null,\"Data\":{\"tm\":1594292307,\"seq\":4,\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_link_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292320,\"seq\":7,\"link_id\":1322606,\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_record_start\",\"Content-Version\":null,\"Data\":{\"tm\":1594292320,\"seq\":9,\"type\":\"order\",\"record_id\":\"NjczMTE0NTMzOjE=\",\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_link_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594292330,\"seq\":11,\"link_id\":1322606,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120,\"call_initiator\":673114539},\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_call_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594292330,\"seq\":13,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120},\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_record_stop\",\"Content-Version\":null,\"Data\":{\"tm\":1594292330,\"seq\":14,\"type\":\"order\",\"record_id\":\"NjczMTE0NTMzOjE=\",\"product_id\":400062183,\"stop_reason\":{\"code\":1000},\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}}],\"answeredByAccount\":\"401530378@mtalker.mangotele.com\"}}]}}";

        JsonObject json_obj = JsonParser.parseString(json).getAsJsonObject();

        JsonArray history_arr = json_obj.getAsJsonObject("data").getAsJsonArray("history");
        for (JsonElement j : history_arr) {
            System.out.println("++++++++++++++");
            System.out.println(j.getAsJsonObject().get("sid").getAsString());
        }
    }

    @Test
    public void test1() {
        String json_path = "src/main/java/jsons/autosecretary/add.json";
        File json_file = new File(json_path);
        System.out.println("exists - " + json_file.exists());

        try {
            JsonObject jsonObject = JsonParser.parseReader(new JsonReader(new FileReader(json_file))).getAsJsonObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        JsonChannel jsonChannel = new JsonChannel();
        System.out.println(jsonChannel.createChannel("local_id_number_example"));
        System.out.println(jsonChannel.editChannel("account_example"));
        System.out.println(jsonChannel.channelSetType("account_example"));
        System.out.println(jsonChannel.addMembers("account_example", "members_example"));
        System.out.println(jsonChannel.removeChanel("account_example"));
        System.out.println(jsonChannel.messageSend("channel_id_example", "local_id_number_example"));
    }


    @Test
    public void test3() {
        //{
        // "sinceTime": 1498413600000,
        // "toTime": 1512604800000,
        // "sinceId": 1,
        // "limit": 100
        //}


        JsonObject json_getData = new JsonObject();
        json_getData.addProperty("sinceTime", 1498413600000L);
        json_getData.addProperty("toTime",1512604800000L);
        json_getData.addProperty("sinceId",1);
        json_getData.addProperty("limit",100);

        // Creates the json object which will manage the information received

        System.out.println(json_getData);

    }



    // КАК ФАЙЛЫ ГРУЗИТЬ!!!!!!!
    @Test
    public void test6(){
        String resourceFile = "src/test/resources";
        String filename = "testavatar.png";

        String file_path = "src/test/resources/testavatar.png";
        File file_avatar = new File(file_path);

        String url = "https://chatapi.mango-office.ru/chat/uploadAvatar";
        String account = "400613768@mtalker.mangotele.com";
        String hash = "180df21b1f0a4dcdd41a169c7b11b4f1";

        String post_request = RestAssured.given()
                .multiPart(new MultiPartSpecBuilder(file_avatar)
                        .controlName("userfile")
                        .fileName(filename)
                        .mimeType("image/png")
                        .build())
                .auth()
                .preemptive()
                .basic(account, hash)
                .param("account", "{21dfcc12-503d-4d2b-b316-ec0b72022ff0}@conference.mtalker.mangotele.com")
                .post(url).asString();

        System.out.println(post_request);
    }

    //given().
    //         multiPart("file1", new File("/home/johan/some_large_file.bin")).
    //         multiPart("file2", new File("/home/johan/some_other_large_file.bin")).
    //         multiPart("file3", "file_name.bin", inputStream).
    //         formParam("name", "value").
    //expect().
    //         body("fileUploadResult", is("OK")).
    //when().
    //         post("/advancedFileUpload");


    //POST https://chatapi.mango-office.ru/chat/uploadAvatar HTTP/1.1
    //Host: chatapi.mango-office.ru
    //User-Agent: M.TALKER/3.10.0/c83b0093b75a0201b95bf78c66692348
    //X-Api-Version: 2
    //Authorization: Basic NDAwNjEzNzY4QG10YWxrZXIubWFuZ290ZWxlLmNvbToxODBkZjIxYjFmMGE0ZGNkZDQxYTE2OWM3YjExYjRmMQ==
    //Content-Type: multipart/form-data; boundary="boundary_.oOo._C6fWqlnJ7NYnSNBbfjGtfwptmX6N1zCy"
    //MIME-Version: 1.0
    //Content-Length: 2847468
    //Connection: Keep-Alive
    //Accept-Encoding: gzip, deflate
    //Accept-Language: ru-RU,en,*
    //
    //--boundary_.oOo._C6fWqlnJ7NYnSNBbfjGtfwptmX6N1zCy
    //Content-Disposition: form-data; name="account"
    //
    //{21dfcc12-503d-4d2b-b316-ec0b72022ff0}@conference.mtalker.mangotele.com
    //--boundary_.oOo._C6fWqlnJ7NYnSNBbfjGtfwptmX6N1zCy
    //Content-Disposition: form-data; name="userfile"; filename="IMG_5855.JPG"
    //Content-Type: image/jpeg



}


