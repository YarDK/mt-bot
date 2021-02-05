package jsons;

import com.google.gson.JsonObject;

public class JsonContactDelPers {

    public String personalContactDel(String id){
        // POST https://chatapi.mango-office.ru/personal/remove HTTP/1.1
        // {"id":"1200000000156371"}
        JsonObject main_json = new JsonObject();
        main_json.addProperty("id",id);
        return main_json.toString();
    }
}
