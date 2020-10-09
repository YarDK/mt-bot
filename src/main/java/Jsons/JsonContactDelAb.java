package Jsons;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonContactDelAb {
    public String contactDelAb(long product_id, String contact_id){
        JsonObject source_id_into = new JsonObject();
        source_id_into.addProperty("index",0);
        source_id_into.addProperty("product_id",product_id);
        source_id_into.addProperty("type","vpbx");

        JsonObject main_json = new JsonObject();
        main_json.add("source_id", source_id_into);
        JsonArray data_arr = new JsonArray();
        data_arr.add(contact_id);
        main_json.add("data",data_arr);

        return main_json.toString();
    }

    // POST https://ab.mango-office.ru/contacts/del HTTP/1.1
    //{
    //   "source_id":{
    //      "index":0,
    //      "product_id":400062183,
    //      "type":"vpbx"
    //   },
    //   "data":[
    //      "57055836"
    //   ]

}
