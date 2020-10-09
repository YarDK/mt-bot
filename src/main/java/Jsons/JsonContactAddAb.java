package Jsons;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonContactAddAb {
    public String jsonContactAdd(){
        // {
        //   "source_id":{
        //      "index":0,
        //      "product_id":400062183,
        //      "type":"vpbx"
        //   },
        //   "data":[
        //      {
        //         "source_id":{
        //            "index":0,
        //            "product_id":400062183,
        //            "type":"vpbx"
        //         },
        //         "type":0,
        //         "name":"Contact Authotest",
        //         "birthday":"",
        //         "avatar":"",
        //         "org":null,
        //         "department":"",
        //         "office":"",
        //         "site":"",
        //         "comment":"",
        //         "phones":[
        //            {
        //               "phone":"85555555555",
        //               "type":4,
        //               "comment":"",
        //               "ext":"",
        //               "is_default":false
        //            }
        //         ],
        //         "emails":[
        //
        //         ]
        //      }
        //   ]
        //}

        JsonObject source_id_into = new JsonObject();
        source_id_into.addProperty("index",0);
        source_id_into.addProperty("product_id",400062183);
        source_id_into.addProperty("type","vpbx");

        JsonObject data_into = new JsonObject();
        data_into.add("source_id", source_id_into);
        data_into.addProperty("type", 0);
        data_into.addProperty("name", String.format("Contact Authotest%s", System.currentTimeMillis()));
        data_into.addProperty("birthday","");
        data_into.addProperty("avatar","");
        data_into.add("org",null);
        data_into.addProperty("department","");
        data_into.addProperty("office","");
        data_into.addProperty("site","");
        data_into.addProperty("comment","");

        JsonObject phones_into = new JsonObject();
        phones_into.addProperty("phone", "8" + System.currentTimeMillis()/2);
        phones_into.addProperty("type", 4);
        phones_into.addProperty("comment", "");
        phones_into.addProperty("ext", "");
        phones_into.addProperty("is_default", false);

        JsonArray phone_arr = new JsonArray();
        phone_arr.add(phones_into);
        data_into.add("phones", phone_arr);

        // Так как массив пустой, то и передвать нечего
        //JsonObject emails_into = new JsonObject();
        JsonArray emails_arr = new JsonArray();
        //emails_arr.add(emails_into);
        data_into.add("emails", emails_arr);

        JsonObject main_json = new JsonObject();
        main_json.add("source_id", source_id_into);

        JsonArray data_arr = new JsonArray();
        data_arr.add(data_into);
        main_json.add("data", data_arr);

        return main_json.toString();
    }
}
