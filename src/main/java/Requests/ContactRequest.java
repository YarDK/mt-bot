package Requests;

import ApplicationManager.MainApplication;
import Jsons.*;
import Models.RegisterData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class ContactRequest extends MainApplication {

    RegisterData data;

    public ContactRequest(RegisterData data) {
        this.data = data;
    }

    public JsonObject addressBookAdd(){
        String json_contact_add = new JsonContactAddAb().jsonContactAdd();
        System.out.println("\nJson contact add:\n" + json_contact_add);
        String url = data.getUrl_ab() + "/contacts/add";
        String contact_add = RestAssured.given()
                .header("X-AUTH-TOKEN", data.getAuth_token())
                .contentType(ContentType.JSON)
                .body(json_contact_add)
                .post(url).asString();
        System.out.println("\nResponse contact add:\n" + contact_add);
        return JsonParser.parseString(contact_add).getAsJsonObject();
    }

    public JsonObject addressBookQuery(String contact_name){
        String json_contact_query = new JsonContactQueryAb().jsonContactQuery(contact_name);
        System.out.println("\nJson contact query:\n" + json_contact_query);
        String url = data.getUrl_ab() + "/contacts/query";
        String contact_query = RestAssured.given()
                .header("X-AUTH-TOKEN", data.getAuth_token())
                .contentType(ContentType.JSON)
                .body(json_contact_query)
                .post(url).asString();
        System.out.println("\nResponse contact query:\n" + contact_query);
        return JsonParser.parseString(contact_query).getAsJsonObject();
    }

    public JsonObject addressBookUpdate(long product_id, String contact_id, String name, String phone_id){
        String json_contact_update = new JsonContactUpdAb().contactUpdAb(product_id, contact_id, name, phone_id);
        System.out.println("\nJson contact update:\n" + json_contact_update);
        String url = data.getUrl_ab() + "/contacts/upd";
        String contact_update = RestAssured.given()
                .header("X-AUTH-TOKEN", data.getAuth_token())
                .contentType(ContentType.JSON)
                .body(json_contact_update)
                .post(url).asString();
        System.out.println("\nResponse contact update:\n" + contact_update);
        return JsonParser.parseString(contact_update).getAsJsonObject();
    }

    public JsonObject addressBookGetContact(long product_id, String contact_id){
        String json_contact_get = new JsonContactGetAb().contactGetAb(product_id, contact_id);
        System.out.println("\nJson contact get:\n" + json_contact_get);
        String url = data.getUrl_ab() + "/contacts/get";
        String contact_get = RestAssured.given()
                .header("X-AUTH-TOKEN", data.getAuth_token())
                .contentType(ContentType.JSON)
                .body(json_contact_get)
                .post(url).asString();
        System.out.println("\nResponse contact get:\n" + contact_get);
        return JsonParser.parseString(contact_get).getAsJsonObject();
    }

    public JsonObject addressBookRemove(long product_id, String contact_id){
        String json_contact_remove = new JsonContactDelAb().contactDelAb(product_id, contact_id);
        System.out.println("\nJson contact remove:\n" + json_contact_remove);
        String url = data.getUrl_ab() + "/contacts/del";
        String contact_remove = RestAssured.given()
                .header("X-AUTH-TOKEN", data.getAuth_token())
                .contentType(ContentType.JSON)
                .body(json_contact_remove)
                .post(url).asString();
        System.out.println("\nResponse contact remove:\n" + contact_remove);
        return JsonParser.parseString(contact_remove).getAsJsonObject();
    }

    public JsonObject personalContactAdd(){
        String json_personal_add = new JsonContactAddPers().personalContactAdd();
        String url = data.getUrl_4talk() + "/personal/add";
        String personal_add = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_personal_add)
                .post(url).asString();
        System.out.println("\nResponse personal add:\n" + personal_add);
        return JsonParser.parseString(personal_add).getAsJsonObject();
    }

    public JsonObject personalContactUpdate(String id){
        String json_personal_update = new JsonContactUpdPers().personalContactUpdate(id);
        String url = data.getUrl_4talk() + "/personal/update";
        String personal_update = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_personal_update)
                .post(url).asString();
        System.out.println("\nResponse personal update:\n" + personal_update);
        return JsonParser.parseString(personal_update).getAsJsonObject();
    }

    public JsonObject personalContactRemove(String id){
        String json_personal_remove = new JsonContactDelPers().personalContactDel(id);
        String url = data.getUrl_4talk() + "/personal/remove";
        String personal_remove = RestAssured.given()
                .auth()
                .preemptive()
                .basic(data.getAccount(), data.getHash())
                .contentType(ContentType.JSON)
                .body(json_personal_remove)
                .post(url).asString();
        System.out.println("\nResponse personal remove:\n" + personal_remove);
        return JsonParser.parseString(personal_remove).getAsJsonObject();
    }
}
