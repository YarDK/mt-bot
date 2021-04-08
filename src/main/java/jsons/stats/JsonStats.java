package jsons.stats;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonStats {

    long sinceTime = 1581075614000L;
    long toTime = 1617795621000L;

    public String getData(){
        JsonObject json_getData = new JsonObject();
        json_getData.addProperty("sinceTime",sinceTime);
        json_getData.addProperty("toTime",toTime);
        json_getData.addProperty("sinceId",1);
        json_getData.addProperty("limit",100);
        return json_getData.toString();
    }

    public String getLaunches(){
        JsonObject json_getData = new JsonObject();
        json_getData.addProperty("sinceTime",sinceTime);
        json_getData.addProperty("toTime",toTime);
        json_getData.addProperty("sinceId",1);
        json_getData.addProperty("limit",100);
        return json_getData.toString();
    }

}
