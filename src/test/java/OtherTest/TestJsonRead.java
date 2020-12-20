package OtherTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;


public class TestJsonRead {


    @Test
    public void test4(){
        String json = "{\"status\":\"ok\",\"statusCode\":200,\"data\":{\"history\":[{\"type\":\"call\",\"outgoing\":true,\"stime\":1594293382000,\"sid\":\"412235106770649152\",\"account\":\"401530378@mtalker.mangotele.com\",\"payload\":{\"callEvents\":[{\"type\":\"outgoing\",\"ctx_seq\":1,\"timestamp\":1594293382,\"call_state\":\"Appeared\",\"call_id\":660745,\"context_id\":9317090255,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":2,\"timestamp\":1594293387,\"call_state\":\"Connected\",\"call_id\":660745,\"context_id\":9317090255,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":6,\"timestamp\":1594293410,\"call_state\":\"Disconnected\",\"disconnect_reason\":1110,\"call_id\":660745,\"context_id\":9317090255,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}}],\"callRecordAvailable\":true,\"wasMissedAndRecalled\":false,\"confEvents\":[{\"Event-Name\":\"on_call_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594293382,\"seq\":0,\"line\":\"\",\"direction\":\"in\",\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\",\"remote_party\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"abonent_id\":402012087,\"internal_number\":565},\"local_party\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870,\"abonent_id\":\"401530378\"}}},{\"Event-Name\":\"on_call_answer\",\"Content-Version\":null,\"Data\":{\"tm\":1594293387,\"seq\":5,\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_link_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594293387,\"seq\":7,\"link_id\":374940,\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_record_start\",\"Content-Version\":null,\"Data\":{\"tm\":1594293387,\"seq\":8,\"type\":\"order\",\"record_id\":\"NjYwNzM2OjA=\",\"product_id\":400062183,\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_call_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293410,\"seq\":10,\"product_id\":400062183,\"destroy_reason\":{\"code\":1100},\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_link_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293410,\"seq\":11,\"link_id\":374940,\"product_id\":400062183,\"destroy_reason\":{\"code\":1110,\"call_initiator\":660736},\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}},{\"Event-Name\":\"on_record_stop\",\"Content-Version\":null,\"Data\":{\"tm\":1594293410,\"seq\":12,\"type\":\"order\",\"record_id\":\"NjYwNzM2OjA=\",\"product_id\":400062183,\"stop_reason\":{\"code\":1000},\"call_id\":660745,\"session_id\":\"MTIxOjkzMTcwOTAyNTU=\"}}],\"answeredByAccount\":\"401530378@mtalker.mangotele.com\"}},{\"type\":\"call\",\"outgoing\":true,\"stime\":1594292974000,\"sid\":\"412235001513818784\",\"account\":\"401530378@mtalker.mangotele.com\",\"payload\":{\"callEvents\":[{\"type\":\"outgoing\",\"ctx_seq\":1,\"timestamp\":1594292974,\"call_state\":\"Appeared\",\"call_id\":673128248,\"context_id\":9316993396,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":2,\"timestamp\":1594292976,\"call_state\":\"Connected\",\"call_id\":673128248,\"context_id\":9316993396,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":5,\"timestamp\":1594293002,\"call_state\":\"Disconnected\",\"disconnect_reason\":1120,\"call_id\":673128248,\"context_id\":9316993396,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}}],\"callRecordAvailable\":false,\"wasMissedAndRecalled\":false,\"confEvents\":[{\"Event-Name\":\"on_call_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292974,\"seq\":0,\"line\":\"\",\"direction\":\"in\",\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\",\"remote_party\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"abonent_id\":402012087,\"internal_number\":565},\"local_party\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870,\"abonent_id\":\"401530378\"}}},{\"Event-Name\":\"on_call_answer\",\"Content-Version\":null,\"Data\":{\"tm\":1594292976,\"seq\":5,\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_link_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292976,\"seq\":7,\"link_id\":1330534,\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_record_start\",\"Content-Version\":null,\"Data\":{\"tm\":1594292976,\"seq\":8,\"type\":\"order\",\"record_id\":\"NjczMTI4MjQwOjA=\",\"product_id\":400062183,\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_link_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293002,\"seq\":11,\"link_id\":1330534,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120,\"call_initiator\":673128248},\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_call_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594293002,\"seq\":13,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120},\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}},{\"Event-Name\":\"on_record_stop\",\"Content-Version\":null,\"Data\":{\"tm\":1594293002,\"seq\":14,\"type\":\"order\",\"record_id\":\"NjczMTI4MjQwOjA=\",\"product_id\":400062183,\"stop_reason\":{\"code\":1000},\"call_id\":673128248,\"session_id\":\"MjAxOjkzMTY5OTMzOTY=\"}}],\"answeredByAccount\":\"401530378@mtalker.mangotele.com\"}},{\"type\":\"call\",\"outgoing\":true,\"stime\":1594292305000,\"sid\":\"412234830818858817\",\"account\":\"401530378@mtalker.mangotele.com\",\"payload\":{\"callEvents\":[{\"type\":\"outgoing\",\"ctx_seq\":1,\"timestamp\":1594292305,\"call_state\":\"Appeared\",\"call_id\":673114539,\"context_id\":9316833837,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":2,\"timestamp\":1594292320,\"call_state\":\"Connected\",\"call_id\":673114539,\"context_id\":9316833837,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}},{\"type\":\"outgoing\",\"ctx_seq\":5,\"timestamp\":1594292330,\"call_state\":\"Disconnected\",\"disconnect_reason\":1120,\"call_id\":673114539,\"context_id\":9316833837,\"from\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"internal_number\":565},\"to\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870}}],\"callRecordAvailable\":false,\"wasMissedAndRecalled\":false,\"confEvents\":[{\"Event-Name\":\"on_call_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292305,\"seq\":0,\"line\":\"\",\"direction\":\"in\",\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\",\"remote_party\":{\"number\":\"sip:testserver@talk.mangosip.ru\",\"abonent_id\":402012087,\"internal_number\":565},\"local_party\":{\"number\":\"sip:test87@talk.mangosip.ru\",\"internal_number\":870,\"abonent_id\":\"401530378\"}}},{\"Event-Name\":\"on_call_answer\",\"Content-Version\":null,\"Data\":{\"tm\":1594292307,\"seq\":4,\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_link_create\",\"Content-Version\":null,\"Data\":{\"tm\":1594292320,\"seq\":7,\"link_id\":1322606,\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_record_start\",\"Content-Version\":null,\"Data\":{\"tm\":1594292320,\"seq\":9,\"type\":\"order\",\"record_id\":\"NjczMTE0NTMzOjE=\",\"product_id\":400062183,\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_link_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594292330,\"seq\":11,\"link_id\":1322606,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120,\"call_initiator\":673114539},\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_call_destroy\",\"Content-Version\":null,\"Data\":{\"tm\":1594292330,\"seq\":13,\"product_id\":400062183,\"destroy_reason\":{\"code\":1120},\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}},{\"Event-Name\":\"on_record_stop\",\"Content-Version\":null,\"Data\":{\"tm\":1594292330,\"seq\":14,\"type\":\"order\",\"record_id\":\"NjczMTE0NTMzOjE=\",\"product_id\":400062183,\"stop_reason\":{\"code\":1000},\"call_id\":673114539,\"session_id\":\"MjAxOjkzMTY4MzM4Mzc=\"}}],\"answeredByAccount\":\"401530378@mtalker.mangotele.com\"}}]}}";

        JsonObject json_obj = JsonParser.parseString(json).getAsJsonObject();

        JsonArray history_arr = json_obj.getAsJsonObject("data").getAsJsonArray("history");
        for(JsonElement j : history_arr){
            System.out.println("++++++++++++++");
            System.out.println(j.getAsJsonObject().get("sid").getAsString());
        }
    }

    @Test
    public void test0(){
        //
        System.out.println(Integer.toString((int)(Math.random()*50 + 10)));
    }

    @Test
    public void test2(){
        JsonArray items_arr = new JsonArray();
        JsonObject schedule_into = new JsonObject();
        schedule_into.addProperty("from","");
        schedule_into.add("items", items_arr);
        schedule_into.addProperty("until","");

        JsonObject numbers_into = new JsonObject();
        numbers_into.addProperty("number","number");
        numbers_into.addProperty("number_id","number_id");
        numbers_into.addProperty("protocol", "protocol");
        numbers_into.add("schedule", schedule_into);
        numbers_into.addProperty("status","on");

        String wait_sec = Integer.toString((int)(Math.random()*50 + 10)); // ( Math.random() * (b-a) ) + a
        numbers_into.addProperty("wait_sec", wait_sec);

        JsonArray numbers_arr = new JsonArray();
        numbers_arr.add(numbers_into);

        JsonObject main_json = new JsonObject();
        main_json.addProperty("dial_alg","all");
        main_json.add("numbers", numbers_arr);
        System.out.println(main_json);
    }

    @Test
    public void test1(){
        // {"status":"ok","statusCode":200,"data":{"lastSid":"414268006569988256","user":{"vcard":{"firstName":"testserver","lastName":"","avatarId":"","mangoExtra":{"general":{"name":"testserver","email":"server4talk@bk.ru","role_id":34311,"sip_ids":["sip:testserver@talk.mangosip.ru"],"position":"Почта mail.ru","member_id":13883076,"abonent_id":402012087,"department":"Пароль 1qw23er45ty","access_role":"admin"},"groups_id":null,"telephony":{"numbers":[{"number":"sip:testserver@talk.mangosip.ru","status":"on","protocol":"sip","schedule":{"from":"","items":[],"until":""},"wait_sec":70,"number_id":13883079}],"dial_alg":"all","extension":"00565","outgoingline":"74951203279","profile_number_id":null}}},"productId":"400062183","dialAlgServices":[{"service_id":400000107,"service_code":"ALG_M_MAIN","service_name":"Дозвон на основной контакт сотрудника"},{"service_id":400000108,"service_code":"ALG_M_ALL","service_name":"Дозвон на все контакты сотрудника одновременно"},{"service_id":400000109,"service_code":"ALG_M_LINE","service_name":"Дозвон на все контакты сотрудника по очереди"}],"status":{"type":"3","text":"","lastSeen":1602234400664,"platform":"0"},"diskSpaceLimit":2147483648,"faxSpaceLimit":104857600,"maxFileSize":2147483648,"maxFaxSize":10485760,"missedCallsCount":0,"permissions":{"telephonyModify":true,"faxSend":true,"balanceView":true,"balancePayment":true,"callRecordsStatus":true,"callRecordsListen":true,"outgoingLineModify":true,"addressbookAccess":true,"addressbookCanCreate":true,"addressbookCanDelete":true,"webchatOperatorActions":false},"regions":[{"name":"Рязань","region":36},{"name":"Воронеж","region":14},{"name":"Ставрополь","region":73},{"name":"Тюмень","region":21},{"name":"Симферополь","region":31},{"name":"Екатеринбург","region":3},{"name":"Казань","region":7},{"name":"Калининград","region":29},{"name":"Белгород","region":62},{"name":"Краснодар","region":15},{"name":"Красноярск","region":12},{"name":"Ижевск","region":38},{"name":"Номера Интернод","region":96},{"name":"Нижний Новгород","region":4},{"name":"Оренбург","region":39},{"name":"Новосибирск","region":10},{"name":"Агентские номера","region":35},{"name":"Омск","region":28},{"name":"Пермь","region":13},{"name":"Прочие регионы","region":6},{"name":"Сочи","region":55},{"name":"Самара","region":8},{"name":"Санкт-Петербург","region":2},{"name":"Саратов","region":20},{"name":"Севастополь","region":30},{"name":"Новый Уренгой","region":88},{"name":"Ростов-на-Дону","region":5},{"name":"Ярославль","region":34},{"name":"Барнаул","region":26},{"name":"Тольятти","region":18},{"name":"Нефтеюганск","region":89},{"name":"Грозный","region":65},{"name":"Липецк","region":37},{"name":"Тула","region":41},{"name":"ТЕСТ_Германия","region":24},{"name":"Ульяновск","region":22},{"name":"Ялта","region":90},{"name":"Калуга","region":46},{"name":"Владимир","region":45},{"name":"Иркутск","region":43},{"name":"Томск","region":44},{"name":"Нижнекамск","region":56},{"name":"Чебоксары","region":42},{"name":"Дзержинск","region":57},{"name":"Магнитогорск","region":48},{"name":"Набережные Челны","region":49},{"name":"СберТел","region":59},{"name":"Киров","region":47},{"name":"Пенза","region":50},{"name":"Тверь","region":51},{"name":"Курган","region":52},{"name":"Курск","region":53},{"name":"Брянск","region":54},{"name":"Йошкар-Ола","region":58},{"name":"Нягань","region":84},{"name":"Ханты-Мансийск","region":76},{"name":"Сургут","region":79},{"name":"Мурманск","region":69},{"name":"Нижневартовск","region":81},{"name":"Волгодонск","region":82},{"name":"Орел","region":70},{"name":"Югорск","region":83},{"name":"Омск-2","region":86},{"name":"Волжский-2","region":87},{"name":"Керчь","region":91},{"name":"Владивосток","region":23},{"name":"Волгоград","region":19},{"name":"Волгоград (номера по агентскому договору)","region":33},{"name":"Волжский","region":32},{"name":"Уфа","region":11},{"name":"Хабаровск","region":27},{"name":"Челябинск","region":9},{"name":"Феодосия","region":92},{"name":"Находка","region":93},{"name":"Старый Оскол","region":94},{"name":"Мобильные номера","region":98},{"name":"Барнаул-2","region":85},{"name":"Номера МСН","region":97},{"name":"Москва","region":1},{"name":"Номера ВымпелКом","region":95},{"name":"Международные номера","region":99},{"name":"Мегафон_лидогенерация","region":100}],"outgoinglines":["73433517499","74951203279","74953749975","74993220983","sip:user5@talk.mangosip.ru","sip:user6@talk.mangosip.ru"],"outgoinglinesRaw":[{"abonent_id":401624876,"number":"73433517499","name":null,"comment":"ЕКБ","region":3},{"abonent_id":400539254,"number":"74951203279","name":null,"comment":"Основной","region":1},{"abonent_id":401624872,"number":"74953749975","name":null,"comment":"ОсновнойОсновной","region":1},{"abonent_id":401624871,"number":"74993220983","name":null,"comment":"Второй новый с очень изменили 1","region":1},{"abonent_id":400791275,"number":"sip:user5@talk.mangosip.ru","name":"74995555555","comment":" ","region":"sip-uac"},{"abonent_id":400791285,"number":"sip:user6@talk.mangosip.ru","name":"79175324514","comment":" ","region":"sip-uac"}],"balance":{"value":1075.24,"currency":"RUB"}},"externalAccountHost":"external.mtalker.mangotele.com","features":["conf_rooms","preview_upload","webchats"]}}

        String json = "{\"status\":\"ok\",\"statusCode\":200,\"data\":{\"lastSid\":\"414268006569988256\",\"user\":{\"vcard\":{\"firstName\":\"testserver\",\"lastName\":\"\",\"avatarId\":\"\",\"mangoExtra\":{\"general\":{\"name\":\"testserver\",\"email\":\"server4talk@bk.ru\",\"role_id\":34311,\"sip_ids\":[\"sip:testserver@talk.mangosip.ru\"],\"position\":\"Почта mail.ru\",\"member_id\":13883076,\"abonent_id\":402012087,\"department\":\"Пароль 1qw23er45ty\",\"access_role\":\"admin\"},\"groups_id\":null,\"telephony\":{\"numbers\":[{\"number\":\"sip:testserver@talk.mangosip.ru\",\"status\":\"on\",\"protocol\":\"sip\",\"schedule\":{\"from\":\"\",\"items\":[],\"until\":\"\"},\"wait_sec\":70,\"number_id\":13883079}],\"dial_alg\":\"all\",\"extension\":\"00565\",\"outgoingline\":\"74951203279\",\"profile_number_id\":null}}},\"productId\":\"400062183\",\"dialAlgServices\":[{\"service_id\":400000107,\"service_code\":\"ALG_M_MAIN\",\"service_name\":\"Дозвон на основной контакт сотрудника\"},{\"service_id\":400000108,\"service_code\":\"ALG_M_ALL\",\"service_name\":\"Дозвон на все контакты сотрудника одновременно\"},{\"service_id\":400000109,\"service_code\":\"ALG_M_LINE\",\"service_name\":\"Дозвон на все контакты сотрудника по очереди\"}],\"status\":{\"type\":\"3\",\"text\":\"\",\"lastSeen\":1602234400664,\"platform\":\"0\"},\"diskSpaceLimit\":2147483648,\"faxSpaceLimit\":104857600,\"maxFileSize\":2147483648,\"maxFaxSize\":10485760,\"missedCallsCount\":0,\"permissions\":{\"telephonyModify\":true,\"faxSend\":true,\"balanceView\":true,\"balancePayment\":true,\"callRecordsStatus\":true,\"callRecordsListen\":true,\"outgoingLineModify\":true,\"addressbookAccess\":true,\"addressbookCanCreate\":true,\"addressbookCanDelete\":true,\"webchatOperatorActions\":false},\"regions\":[{\"name\":\"Рязань\",\"region\":36},{\"name\":\"Воронеж\",\"region\":14},{\"name\":\"Ставрополь\",\"region\":73},{\"name\":\"Тюмень\",\"region\":21},{\"name\":\"Симферополь\",\"region\":31},{\"name\":\"Екатеринбург\",\"region\":3},{\"name\":\"Казань\",\"region\":7},{\"name\":\"Калининград\",\"region\":29},{\"name\":\"Белгород\",\"region\":62},{\"name\":\"Краснодар\",\"region\":15},{\"name\":\"Красноярск\",\"region\":12},{\"name\":\"Ижевск\",\"region\":38},{\"name\":\"Номера Интернод\",\"region\":96},{\"name\":\"Нижний Новгород\",\"region\":4},{\"name\":\"Оренбург\",\"region\":39},{\"name\":\"Новосибирск\",\"region\":10},{\"name\":\"Агентские номера\",\"region\":35},{\"name\":\"Омск\",\"region\":28},{\"name\":\"Пермь\",\"region\":13},{\"name\":\"Прочие регионы\",\"region\":6},{\"name\":\"Сочи\",\"region\":55},{\"name\":\"Самара\",\"region\":8},{\"name\":\"Санкт-Петербург\",\"region\":2},{\"name\":\"Саратов\",\"region\":20},{\"name\":\"Севастополь\",\"region\":30},{\"name\":\"Новый Уренгой\",\"region\":88},{\"name\":\"Ростов-на-Дону\",\"region\":5},{\"name\":\"Ярославль\",\"region\":34},{\"name\":\"Барнаул\",\"region\":26},{\"name\":\"Тольятти\",\"region\":18},{\"name\":\"Нефтеюганск\",\"region\":89},{\"name\":\"Грозный\",\"region\":65},{\"name\":\"Липецк\",\"region\":37},{\"name\":\"Тула\",\"region\":41},{\"name\":\"ТЕСТ_Германия\",\"region\":24},{\"name\":\"Ульяновск\",\"region\":22},{\"name\":\"Ялта\",\"region\":90},{\"name\":\"Калуга\",\"region\":46},{\"name\":\"Владимир\",\"region\":45},{\"name\":\"Иркутск\",\"region\":43},{\"name\":\"Томск\",\"region\":44},{\"name\":\"Нижнекамск\",\"region\":56},{\"name\":\"Чебоксары\",\"region\":42},{\"name\":\"Дзержинск\",\"region\":57},{\"name\":\"Магнитогорск\",\"region\":48},{\"name\":\"Набережные Челны\",\"region\":49},{\"name\":\"СберТел\",\"region\":59},{\"name\":\"Киров\",\"region\":47},{\"name\":\"Пенза\",\"region\":50},{\"name\":\"Тверь\",\"region\":51},{\"name\":\"Курган\",\"region\":52},{\"name\":\"Курск\",\"region\":53},{\"name\":\"Брянск\",\"region\":54},{\"name\":\"Йошкар-Ола\",\"region\":58},{\"name\":\"Нягань\",\"region\":84},{\"name\":\"Ханты-Мансийск\",\"region\":76},{\"name\":\"Сургут\",\"region\":79},{\"name\":\"Мурманск\",\"region\":69},{\"name\":\"Нижневартовск\",\"region\":81},{\"name\":\"Волгодонск\",\"region\":82},{\"name\":\"Орел\",\"region\":70},{\"name\":\"Югорск\",\"region\":83},{\"name\":\"Омск-2\",\"region\":86},{\"name\":\"Волжский-2\",\"region\":87},{\"name\":\"Керчь\",\"region\":91},{\"name\":\"Владивосток\",\"region\":23},{\"name\":\"Волгоград\",\"region\":19},{\"name\":\"Волгоград (номера по агентскому договору)\",\"region\":33},{\"name\":\"Волжский\",\"region\":32},{\"name\":\"Уфа\",\"region\":11},{\"name\":\"Хабаровск\",\"region\":27},{\"name\":\"Челябинск\",\"region\":9},{\"name\":\"Феодосия\",\"region\":92},{\"name\":\"Находка\",\"region\":93},{\"name\":\"Старый Оскол\",\"region\":94},{\"name\":\"Мобильные номера\",\"region\":98},{\"name\":\"Барнаул-2\",\"region\":85},{\"name\":\"Номера МСН\",\"region\":97},{\"name\":\"Москва\",\"region\":1},{\"name\":\"Номера ВымпелКом\",\"region\":95},{\"name\":\"Международные номера\",\"region\":99},{\"name\":\"Мегафон_лидогенерация\",\"region\":100}],\"outgoinglines\":[\"73433517499\",\"74951203279\",\"74953749975\",\"74993220983\",\"sip:user5@talk.mangosip.ru\",\"sip:user6@talk.mangosip.ru\"],\"outgoinglinesRaw\":[{\"abonent_id\":401624876,\"number\":\"73433517499\",\"name\":null,\"comment\":\"ЕКБ\",\"region\":3},{\"abonent_id\":400539254,\"number\":\"74951203279\",\"name\":null,\"comment\":\"Основной\",\"region\":1},{\"abonent_id\":401624872,\"number\":\"74953749975\",\"name\":null,\"comment\":\"ОсновнойОсновной\",\"region\":1},{\"abonent_id\":401624871,\"number\":\"74993220983\",\"name\":null,\"comment\":\"Второй новый с очень изменили 1\",\"region\":1},{\"abonent_id\":400791275,\"number\":\"sip:user5@talk.mangosip.ru\",\"name\":\"74995555555\",\"comment\":\" \",\"region\":\"sip-uac\"},{\"abonent_id\":400791285,\"number\":\"sip:user6@talk.mangosip.ru\",\"name\":\"79175324514\",\"comment\":\" \",\"region\":\"sip-uac\"}],\"balance\":{\"value\":1075.24,\"currency\":\"RUB\"}},\"externalAccountHost\":\"external.mtalker.mangotele.com\",\"features\":[\"conf_rooms\",\"preview_upload\",\"webchats\"]}}";

        // {
        //   "status":"ok",
        //   "statusCode":200,
        //   "data":{
        //      "lastSid":"414268006569988256",
        //      "user":{
        //         "vcard":{
        //            "firstName":"testserver",
        //            "lastName":"",
        //            "avatarId":"",
        //            "mangoExtra":{
        //               "general":{
        JsonObject json_obj = JsonParser.parseString(json).getAsJsonObject();

        System.out.println("abonent_id: " + json_obj
                .getAsJsonObject("data")
                .getAsJsonObject("user")
                .getAsJsonObject("vcard")
                .getAsJsonObject("mangoExtra")
                .getAsJsonObject("general")
                .get("abonent_id").getAsString()
        );

        System.out.println("productId: " + json_obj
                .getAsJsonObject("data")
                .getAsJsonObject("user")
                .get("productId").getAsString()
        );

        System.out.println("lastSeen: " + json_obj
                .getAsJsonObject("data")
                .getAsJsonObject("user")
                .getAsJsonObject("status")
                .get("lastSeen").getAsString()
        );

        System.out.println("number_id: " + json_obj
                .getAsJsonObject("data")
                .getAsJsonObject("user")
                .getAsJsonObject("vcard")
                .getAsJsonObject("mangoExtra")
                .getAsJsonObject("telephony")
                .getAsJsonArray("numbers").get(0).getAsJsonObject()
                .get("number_id").getAsString()
        );

        //                  "name":"testserver",
        //                  "email":"server4talk@bk.ru",
        //                  "role_id":34311,
        //                  "sip_ids":[
        //                     "sip:testserver@talk.mangosip.ru"
        //                  ],
        //                  "position":"Почта mail.ru",
        //                  "member_id":13883076,
        //                  "abonent_id":402012087,
        //                  "department":"Пароль 1qw23er45ty",
        //                  "access_role":"admin"
        //               },
        //               "groups_id":null,
        //               "telephony":{
        //                  "numbers":[
        //                     {
        //                        "number":"sip:testserver@talk.mangosip.ru",
        //                        "status":"on",
        //                        "protocol":"sip",
        //                        "schedule":{
        //                           "from":"",
        //                           "items":[
        //
        //                           ],
        //                           "until":""
        //                        },
        //                        "wait_sec":70,
        //                        "number_id":13883079
        //                     }
        //                  ],
        //                  "dial_alg":"all",
        //                  "extension":"00565",
        //                  "outgoingline":"74951203279",
        //                  "profile_number_id":null
        //               }
        //            }
        //         },
        //         "productId":"400062183",
        //         "dialAlgServices":[
        //            {
        //               "service_id":400000107,
        //               "service_code":"ALG_M_MAIN",
        //               "service_name":"Дозвон на основной контакт сотрудника"
        //            },
        //            {
        //               "service_id":400000108,
        //               "service_code":"ALG_M_ALL",
        //               "service_name":"Дозвон на все контакты сотрудника одновременно"
        //            },
        //            {
        //               "service_id":400000109,
        //               "service_code":"ALG_M_LINE",
        //               "service_name":"Дозвон на все контакты сотрудника по очереди"
        //            }
        //         ],
        //         "status":{
        //            "type":"3",
        //            "text":"",
        //            "lastSeen":1602234400664,
        //            "platform":"0"
        //         },
        //         "diskSpaceLimit":2147483648,
        //         "faxSpaceLimit":104857600,
        //         "maxFileSize":2147483648,
        //         "maxFaxSize":10485760,
        //         "missedCallsCount":0,
        //         "permissions":{
        //            "telephonyModify":true,
        //            "faxSend":true,
        //            "balanceView":true,
        //            "balancePayment":true,
        //            "callRecordsStatus":true,
        //            "callRecordsListen":true,
        //            "outgoingLineModify":true,
        //            "addressbookAccess":true,
        //            "addressbookCanCreate":true,
        //            "addressbookCanDelete":true,
        //            "webchatOperatorActions":false
        //         },
        //         "regions":[
        //            {
        //               "name":"Рязань",
        //               "region":36
        //            },
        //            {
        //               "name":"Воронеж",
        //               "region":14
        //            },
        //            {
        //               "name":"Ставрополь",
        //               "region":73
        //            },
        //            {
        //               "name":"Тюмень",
        //               "region":21
        //            },
        //            {
        //               "name":"Симферополь",
        //               "region":31
        //            },
        //            {
        //               "name":"Екатеринбург",
        //               "region":3
        //            },
        //            {
        //               "name":"Казань",
        //               "region":7
        //            },
        //            {
        //               "name":"Калининград",
        //               "region":29
        //            },
        //            {
        //               "name":"Белгород",
        //               "region":62
        //            },
        //            {
        //               "name":"Краснодар",
        //               "region":15
        //            },
        //            {
        //               "name":"Красноярск",
        //               "region":12
        //            },
        //            {
        //               "name":"Ижевск",
        //               "region":38
        //            },
        //            {
        //               "name":"Номера Интернод",
        //               "region":96
        //            },
        //            {
        //               "name":"Нижний Новгород",
        //               "region":4
        //            },
        //            {
        //               "name":"Оренбург",
        //               "region":39
        //            },
        //            {
        //               "name":"Новосибирск",
        //               "region":10
        //            },
        //            {
        //               "name":"Агентские номера",
        //               "region":35
        //            },
        //            {
        //               "name":"Омск",
        //               "region":28
        //            },
        //            {
        //               "name":"Пермь",
        //               "region":13
        //            },
        //            {
        //               "name":"Прочие регионы",
        //               "region":6
        //            },
        //            {
        //               "name":"Сочи",
        //               "region":55
        //            },
        //            {
        //               "name":"Самара",
        //               "region":8
        //            },
        //            {
        //               "name":"Санкт-Петербург",
        //               "region":2
        //            },
        //            {
        //               "name":"Саратов",
        //               "region":20
        //            },
        //            {
        //               "name":"Севастополь",
        //               "region":30
        //            },
        //            {
        //               "name":"Новый Уренгой",
        //               "region":88
        //            },
        //            {
        //               "name":"Ростов-на-Дону",
        //               "region":5
        //            },
        //            {
        //               "name":"Ярославль",
        //               "region":34
        //            },
        //            {
        //               "name":"Барнаул",
        //               "region":26
        //            },
        //            {
        //               "name":"Тольятти",
        //               "region":18
        //            },
        //            {
        //               "name":"Нефтеюганск",
        //               "region":89
        //            },
        //            {
        //               "name":"Грозный",
        //               "region":65
        //            },
        //            {
        //               "name":"Липецк",
        //               "region":37
        //            },
        //            {
        //               "name":"Тула",
        //               "region":41
        //            },
        //            {
        //               "name":"ТЕСТ_Германия",
        //               "region":24
        //            },
        //            {
        //               "name":"Ульяновск",
        //               "region":22
        //            },
        //            {
        //               "name":"Ялта",
        //               "region":90
        //            },
        //            {
        //               "name":"Калуга",
        //               "region":46
        //            },
        //            {
        //               "name":"Владимир",
        //               "region":45
        //            },
        //            {
        //               "name":"Иркутск",
        //               "region":43
        //            },
        //            {
        //               "name":"Томск",
        //               "region":44
        //            },
        //            {
        //               "name":"Нижнекамск",
        //               "region":56
        //            },
        //            {
        //               "name":"Чебоксары",
        //               "region":42
        //            },
        //            {
        //               "name":"Дзержинск",
        //               "region":57
        //            },
        //            {
        //               "name":"Магнитогорск",
        //               "region":48
        //            },
        //            {
        //               "name":"Набережные Челны",
        //               "region":49
        //            },
        //            {
        //               "name":"СберТел",
        //               "region":59
        //            },
        //            {
        //               "name":"Киров",
        //               "region":47
        //            },
        //            {
        //               "name":"Пенза",
        //               "region":50
        //            },
        //            {
        //               "name":"Тверь",
        //               "region":51
        //            },
        //            {
        //               "name":"Курган",
        //               "region":52
        //            },
        //            {
        //               "name":"Курск",
        //               "region":53
        //            },
        //            {
        //               "name":"Брянск",
        //               "region":54
        //            },
        //            {
        //               "name":"Йошкар-Ола",
        //               "region":58
        //            },
        //            {
        //               "name":"Нягань",
        //               "region":84
        //            },
        //            {
        //               "name":"Ханты-Мансийск",
        //               "region":76
        //            },
        //            {
        //               "name":"Сургут",
        //               "region":79
        //            },
        //            {
        //               "name":"Мурманск",
        //               "region":69
        //            },
        //            {
        //               "name":"Нижневартовск",
        //               "region":81
        //            },
        //            {
        //               "name":"Волгодонск",
        //               "region":82
        //            },
        //            {
        //               "name":"Орел",
        //               "region":70
        //            },
        //            {
        //               "name":"Югорск",
        //               "region":83
        //            },
        //            {
        //               "name":"Омск-2",
        //               "region":86
        //            },
        //            {
        //               "name":"Волжский-2",
        //               "region":87
        //            },
        //            {
        //               "name":"Керчь",
        //               "region":91
        //            },
        //            {
        //               "name":"Владивосток",
        //               "region":23
        //            },
        //            {
        //               "name":"Волгоград",
        //               "region":19
        //            },
        //            {
        //               "name":"Волгоград (номера по агентскому договору)",
        //               "region":33
        //            },
        //            {
        //               "name":"Волжский",
        //               "region":32
        //            },
        //            {
        //               "name":"Уфа",
        //               "region":11
        //            },
        //            {
        //               "name":"Хабаровск",
        //               "region":27
        //            },
        //            {
        //               "name":"Челябинск",
        //               "region":9
        //            },
        //            {
        //               "name":"Феодосия",
        //               "region":92
        //            },
        //            {
        //               "name":"Находка",
        //               "region":93
        //            },
        //            {
        //               "name":"Старый Оскол",
        //               "region":94
        //            },
        //            {
        //               "name":"Мобильные номера",
        //               "region":98
        //            },
        //            {
        //               "name":"Барнаул-2",
        //               "region":85
        //            },
        //            {
        //               "name":"Номера МСН",
        //               "region":97
        //            },
        //            {
        //               "name":"Москва",
        //               "region":1
        //            },
        //            {
        //               "name":"Номера ВымпелКом",
        //               "region":95
        //            },
        //            {
        //               "name":"Международные номера",
        //               "region":99
        //            },
        //            {
        //               "name":"Мегафон_лидогенерация",
        //               "region":100
        //            }
        //         ],
        //         "outgoinglines":[
        //            "73433517499",
        //            "74951203279",
        //            "74953749975",
        //            "74993220983",
        //            "sip:user5@talk.mangosip.ru",
        //            "sip:user6@talk.mangosip.ru"
        //         ],
        //         "outgoinglinesRaw":[
        //            {
        //               "abonent_id":401624876,
        //               "number":"73433517499",
        //               "name":null,
        //               "comment":"ЕКБ",
        //               "region":3
        //            },
        //            {
        //               "abonent_id":400539254,
        //               "number":"74951203279",
        //               "name":null,
        //               "comment":"Основной",
        //               "region":1
        //            },
        //            {
        //               "abonent_id":401624872,
        //               "number":"74953749975",
        //               "name":null,
        //               "comment":"ОсновнойОсновной",
        //               "region":1
        //            },
        //            {
        //               "abonent_id":401624871,
        //               "number":"74993220983",
        //               "name":null,
        //               "comment":"Второй новый с очень изменили 1",
        //               "region":1
        //            },
        //            {
        //               "abonent_id":400791275,
        //               "number":"sip:user5@talk.mangosip.ru",
        //               "name":"74995555555",
        //               "comment":" ",
        //               "region":"sip-uac"
        //            },
        //            {
        //               "abonent_id":400791285,
        //               "number":"sip:user6@talk.mangosip.ru",
        //               "name":"79175324514",
        //               "comment":" ",
        //               "region":"sip-uac"
        //            }
        //         ],
        //         "balance":{
        //            "value":1075.24,
        //            "currency":"RUB"
        //         }
        //      },
        //      "externalAccountHost":"external.mtalker.mangotele.com",
        //      "features":[
        //         "conf_rooms",
        //         "preview_upload",
        //         "webchats"
        //      ]
        //   }
        //}


    }

}
