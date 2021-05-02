package ApplicationManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PollEventsListener extends MainApplication{

    String command;
    String account;

    public void Listener(){
        while (true) {
            System.out.println(response(runner.data().getLastSid()));
            if(command != null){
                if(command.equals("stop")){
                    break;
                } else if(command.equals("help")){
                    sendMessage("Да хрена тебе лысого!");
                }
            }

            runner.waiter(5000);
        }
    }

    public String response(String sid){
        JsonObject response = runner.session().pollEvents(sid);
        getMessage(response);
        return response.get("data").getAsJsonObject().get("lastSid").getAsString();
    }

    public void sendMessage(String message){
        String local_id = "abcdef0123456700000" + System.currentTimeMillis();;
        runner.chat().personalChatCreate(local_id, account, message);
    }

    public void getMessage(JsonObject response){
        JsonArray history_arr = response.getAsJsonObject("data").getAsJsonArray("history");
        for (JsonElement j : history_arr) {
            int type = j.getAsJsonObject().get("type").getAsInt();
            if (type == 401){
                command = j.getAsJsonObject().get("message")
                        .getAsJsonObject().get("payload")
                        .getAsJsonObject().get("body").getAsString();
                account = j.getAsJsonObject().get("message")
                        .getAsJsonObject().get("account").getAsString();
                System.out.println(command + " from " + account);
            }
        }
    }
}
