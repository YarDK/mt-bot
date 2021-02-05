package jsons;

import com.google.gson.JsonObject;

public class JsonStatus {

    public String away(){
        JsonObject main_json = new JsonObject();
        main_json.addProperty("status","7"); // Соответствует статусу "Отошел"
        main_json.addProperty("textStatus","");
        return main_json.toString();
    }

    public String dnd(long dndTillTime, String previousStatus){
        JsonObject main_json = new JsonObject();
        main_json.addProperty("status","8"); // Соответствует статусу "Не беспокоить"
        main_json.addProperty("textStatus","");

        if (previousStatus.equals("online")) {
            main_json.addProperty("previousStatus", "3");
        } else {
            main_json.addProperty("previousStatus", "7");
        }

        main_json.addProperty("dndTillTime", dndTillTime);
        return main_json.toString();
    }

    public String online(){
        JsonObject main_json = new JsonObject();
        main_json.addProperty("status","3"); // Соответствует статусу "Онлайн"
        main_json.addProperty("textStatus","");
        return main_json.toString();
    }
}
