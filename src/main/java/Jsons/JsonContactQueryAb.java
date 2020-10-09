package Jsons;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonContactQueryAb {
    public String jsonContactQuery(String contact_name){
        // {
        //   "product_id":400062183,
        //   "sources":[
        //      {
        //         "index":0,
        //         "product_id":400062183,
        //         "type":"vpbx"
        //      }
        //   ],
        //   "limit_rows":200,
        //   "filter":null,
        //   "query":"autho",
        //   "order":{
        //      "name":"ASC"
        //   },
        //   "version":"v2"
        //}

        JsonObject sources_into = new JsonObject();
        sources_into.addProperty("index", 0);
        sources_into.addProperty("product_id", 400062183);
        sources_into.addProperty("type", "vpbx");

        JsonArray sources_arr = new JsonArray();
        sources_arr.add(sources_into);

        JsonObject order_into = new JsonObject();
        order_into.addProperty("name", "ASC");

        JsonObject main_json = new JsonObject();
        main_json.addProperty("product_id", 400062183);
        main_json.add("sources",sources_arr);
        main_json.addProperty("limit_rows", 200);
        main_json.add("filter", null);
        main_json.addProperty("query",contact_name);
        main_json.add("order", order_into);
        main_json.addProperty("version","v2");

        return main_json.toString();
    }
}
