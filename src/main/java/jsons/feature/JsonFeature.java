package jsons.feature;

import com.google.gson.JsonObject;

public class JsonFeature {

    public String getForProduct(String product_id){
        JsonObject main_json = new JsonObject();
        main_json.addProperty("productId", product_id);
        return main_json.toString();
    }
}
