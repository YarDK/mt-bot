package jsons.contacts.employee;

import com.google.gson.JsonObject;

public class JsonEmployee {

    // Добавление в избранное
    public String rosterEdit(String account, Boolean pinned){
        JsonObject main_json = new JsonObject();
        main_json.addProperty("account", account);
        main_json.addProperty("pinned", pinned);
        return main_json.toString();
    }



}
