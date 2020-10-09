package ApplicationManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MainMethods {

    public void waiter(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод возвращается timestamp до которого должен быть включен статус "Не беспокоить"
    public long timeStampToFinishDnd(long dnd_in_minute) {
        int millisecond_in_minute = 60000;
        long minute_to_millisecond = dnd_in_minute * millisecond_in_minute;
        Date date_now = new Date();
        Date date_to_finish_dnd = new Date(date_now.getTime() + minute_to_millisecond);
        System.out.println("\nTime to finish DND: " + date_to_finish_dnd + "\n");
        return date_to_finish_dnd.getTime();
    }

    public Set<String> getSid(JsonObject response_calls_recent){
        Set<String> sid_list = new HashSet<>();
        JsonArray history_arr = response_calls_recent.getAsJsonObject("data").getAsJsonArray("history");
        for(JsonElement j : history_arr){
            sid_list.add(j.getAsJsonObject().get("sid").getAsString());
        }
        return sid_list;
    }

}
