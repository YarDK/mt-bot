package jsons.contacts.addressbook;

import com.google.gson.JsonObject;

public class JsonContactGetAb {

    public String contactGetAb(long product_id, String contact_id){
        // POST https://ab.mango-office.ru/contacts/get HTTP/1.1
        // {
        //   "source_id":{
        //      "index":0,
        //      "product_id":400062183,
        //      "type":"vpbx"
        //   },
        //   "contact_id":"57055836"
        //}

        JsonObject source_id_into = new JsonObject();
        source_id_into.addProperty("index",0);
        source_id_into.addProperty("product_id",product_id);
        source_id_into.addProperty("type","vpbx");

        JsonObject main_json = new JsonObject();
        main_json.add("source_id", source_id_into);
        main_json.addProperty("contact_id",contact_id);

        return main_json.toString();
    }
}
