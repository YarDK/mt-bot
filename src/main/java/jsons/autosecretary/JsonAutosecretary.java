package jsons.autosecretary;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonAutosecretary {

    //{
    //  "rule": {
    //    "actions": [
    //      {
    //        "action": "end_call",
    //        "param": ""
    //      }
    //    ],
    //    "active": false,
    //    "direction": [
    //      "incoming",
    //      "internal"
    //    ],
    //    "melody_id": null,
    //    "name": "Правило переадресации 2",
    //    "notifications": [],
    //    "rule_id": 60484,
    //    "wait_time": 0
    //  }
    //}

    public String update(int rule_id) {

        JsonObject actions_into = new JsonObject();
        actions_into.addProperty("action", "end_call");
        actions_into.addProperty("param", "");
        JsonArray actions_arr = new JsonArray();
        actions_arr.add(actions_into);

        JsonArray direction_arr = new JsonArray();
        direction_arr.add("incoming");
        direction_arr.add("internal");

        JsonObject rule_into = new JsonObject();
        rule_into.add("actions", actions_arr);
        rule_into.addProperty("active", false);
        rule_into.add("direction", direction_arr);
        rule_into.add("melody_id", null);
        rule_into.addProperty("name", "Update rule name autotest");
        rule_into.add("notifications", new JsonArray());
        rule_into.addProperty("rule_id", rule_id);
        rule_into.addProperty("wait_time", 0);

        JsonObject rule = new JsonObject();
        rule.add("rule", rule_into);

        return rule.toString();
    }


    // {}
    public String get(){
        return new JsonObject().toString();
    }

    public String del(int rule_id){
        JsonArray rules_arr = new JsonArray();
        rules_arr.add(rule_id);

        JsonObject rules = new JsonObject();
        rules.add("rules", rules_arr);

        return rules.toString();
    }

}
