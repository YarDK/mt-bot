package jsons;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonSaveSettings {

    public String saveSettings(String number, long number_id, String protocol){

        JsonArray items_arr = new JsonArray();
        JsonObject schedule_into = new JsonObject();
        schedule_into.addProperty("from","");
        schedule_into.add("items", items_arr);
        schedule_into.addProperty("until","");

        JsonObject numbers_into = new JsonObject();
        numbers_into.addProperty("number",number);
        numbers_into.addProperty("number_id",number_id);
        numbers_into.addProperty("protocol", protocol);
        numbers_into.add("schedule", schedule_into);
        numbers_into.addProperty("status","on");

        // ( Math.random() * (b-a) ) + a
        numbers_into.addProperty("wait_sec", (int)(Math.random()*50 + 10));

        JsonArray numbers_arr = new JsonArray();
        numbers_arr.add(numbers_into);

        JsonObject main_json = new JsonObject();
        main_json.addProperty("dial_alg","all");
        main_json.add("numbers", numbers_arr);

        return main_json.toString();
    }

    // {
    //   "dial_alg":"all",
    //   "numbers":[
    //      {
    //         "number":"sip:testserver@talk.mangosip.ru",
    //         "number_id":13883079,
    //         "protocol":"sip",
    //         "schedule":{
    //            "from":"",
    //            "items":[
    //
    //            ],
    //            "until":""
    //         },
    //         "status":"on",
    //         "wait_sec":60
    //      }
    //   ]
    //}

}
