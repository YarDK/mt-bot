package jsons.settings;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonSettings {

    public String setWorkingHours(Boolean isEnabled) {
        //{
        //    isEnabled: true,
        //    schedule: {
        //        days: [1,2,3,4,5], // Массив номеров рабочих дней от 0 до 6 где 0 это воскресенье
        //        start: '09:00', // время UTC начала рабочего дня
        //        end: '20:00' // время UTC окончания рабочего дня
        //    }
        //}
        JsonObject main_json = new JsonObject();
        main_json.addProperty("isEnabled", isEnabled);

        JsonObject schedule_into = new JsonObject();

        JsonArray days_arr = new JsonArray();
        days_arr.add(0);
        days_arr.add(2);
        days_arr.add(3);
        days_arr.add(4);
        days_arr.add(5);
        days_arr.add(6);
        schedule_into.add("days", days_arr);
        schedule_into.addProperty("start", "09:00");
        schedule_into.addProperty("end", "20:00");

        main_json.add("schedule", schedule_into);

        return main_json.toString();
    }
}
