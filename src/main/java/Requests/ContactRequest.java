package Requests;

import ApplicationManager.RunnerApplication;
import Models.RegisterData;
import com.google.gson.JsonObject;
import jsons.contacts.addressbook.*;
import jsons.contacts.employee.JsonEmployee;
import jsons.contacts.personal.*;

public class ContactRequest extends RunnerApplication {

    RegisterData data;

    public ContactRequest(RegisterData data) {
        this.data = data;
    }

    public JsonObject addressBookAdd(){
        String json = new JsonContactAddAb().jsonContactAdd();
        String url = data.getUrl_ab() + "/contacts/add";
        return post_response(json, url, data, true);
    }

    public JsonObject addressBookQuery(String contact_name){
        String json = new JsonContactQueryAb().jsonContactQuery(contact_name);
        String url = data.getUrl_ab() + "/contacts/query";
        return post_response(json, url, data, true);
    }

    public JsonObject addressBookUpdate(long product_id, String contact_id, String name, String phone_id){
        String json = new JsonContactUpdAb().contactUpdAb(product_id, contact_id, name, phone_id);
        String url = data.getUrl_ab() + "/contacts/upd";
        return post_response(json, url, data, true);
    }

    public JsonObject addressBookGetContact(long product_id, String contact_id){
        String json = new JsonContactGetAb().contactGetAb(product_id, contact_id);
        String url = data.getUrl_ab() + "/contacts/get";
        return post_response(json, url, data, true);
    }

    public JsonObject addressBookRemove(long product_id, String contact_id){
        String json = new JsonContactDelAb().contactDelAb(product_id, contact_id);
        String url = data.getUrl_ab() + "/contacts/del";
        return post_response(json, url, data, true);
    }

    public JsonObject addressBookQueryByPhone(long product_id){
        String json = "{\"product_id\":"+product_id+",\"query\":[\"86549871244\"],\"sources\":[]}";
        String url = data.getUrl_ab() + "/contacts/get-by-phone";
        return post_response(json, url, data, true);
    }

    public JsonObject addressBookSrcList(long product_id){
        String json = "{\"product_id\":"+product_id+"}";
        String url = data.getUrl_ab() + "/src/list";
        return post_response(json, url, data, true);
    }

    public JsonObject personalContactAdd(){
        String json = new JsonContactAddPers().personalContactAdd();
        String url = "/personal/add";
        return post_response(json, url, data);
    }

    public JsonObject personalContactUpdate(String id){
        String json = new JsonContactUpdPers().personalContactUpdate(id);
        String url = "/personal/update";
        return post_response(json, url, data);
    }

    public JsonObject personalContactSave(){
        String json = getJson("src/main/java/jsons/contacts/personal/save.json");
        String url = "/personal/save";
        return post_response(json, url, data);
    }

    public JsonObject personalContactRemove(String id){
        String json = new JsonContactDelPers().personalContactDel(id);
        String url = "/personal/remove";
        return post_response(json, url, data);
    }

    public JsonObject personalContactRemoveAll(){
        String json = "{}";
        String url = "/personal/removeAll";
        return post_response(json, url, data);
    }

    public JsonObject personalContactGetList(){
        String json = "{}";
        String url = "/personal/getList";
        return post_response(json, url, data);
    }

    //Список сотрудников (метод не используется, заменен на Execute
    public JsonObject rosterGetList(){
        String json = "{}";
        String url = "/roster/getList";
        return post_response(json, url, data);
    }

    // Добавить в Избранное сотрудника
    public JsonObject rosterEdit(String account, Boolean pinned){
        String json = new JsonEmployee().rosterEdit(account,pinned);
        String url = "/roster/edit";
        return post_response(json, url, data);
    }


}
