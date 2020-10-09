package Jsons;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonContactUpdPers {

    public String personalContactUpdate(String id){

        JsonObject phone1_into = new JsonObject();
        phone1_into.addProperty("type","mobile");
        phone1_into.addProperty("phone","+79601111111");

        JsonObject phone2_into = new JsonObject();
        phone2_into.addProperty("type","home");
        phone2_into.addProperty("phone","79602222222");

        JsonArray phones_arr = new JsonArray();
        phones_arr.add(phone1_into);
        phones_arr.add(phone2_into);

        JsonObject email1_into = new JsonObject();
        email1_into.addProperty("type","home");
        email1_into.addProperty("email","1@yandex.ru");

        JsonObject email2_into = new JsonObject();
        email2_into.addProperty("type","work");
        email2_into.addProperty("email","2@yandex.ru");

        JsonArray emails_arr = new JsonArray();
        emails_arr.add(email1_into);
        emails_arr.add(email2_into);

        JsonArray sipIds_arr = new JsonArray();
        sipIds_arr.add("1@mango.com");
        sipIds_arr.add("2@mango.com");

        JsonObject contactData_into = new JsonObject();
        contactData_into.addProperty("id",id); // надо вытаскивать id
        contactData_into.addProperty("flags" , 0);
        contactData_into.addProperty("firstName","Ivan");
        contactData_into.addProperty("lastName","Test");
        contactData_into.addProperty("company","5talk");
        contactData_into.addProperty("position","Developer");
        contactData_into.add("phones", phones_arr);
        contactData_into.add("emails", emails_arr);
        contactData_into.add("sipIds", sipIds_arr);
        contactData_into.addProperty("url", "http://4talk.com");
        contactData_into.addProperty("note","NOTE NOTE");

        JsonObject main_json = new JsonObject();
        main_json.add("contactData", contactData_into);
        main_json.addProperty("localId","3b318389038f45519d973843a59fcd8e");
        return main_json.toString();
    }

    // {
    //  "contactData": {
    //    "id": "@id@",
    //    "flags" : 0,
    //    "firstName": "Ivan",
    //    "lastName": "Ivanov",
    //    "company": "5talk",
    //    "position": "@position@",
    //    "phones": [
    //      {
    //        "type": "mobile",
    //        "phone": "+79601111111"
    //      },
    //      {
    //        "type": "home",
    //        "phone": " 79602222222"
    //      }
    //    ],
    //    "emails": [
    //      {
    //        "type": "home",
    //        "email": "1@yandex.ru"
    //      },
    //      {
    //        "type": "work",
    //        "email": "2@yandex.ru"
    //      }
    //    ],
    //    "sipIds": [
    //      "1@mango.com",
    //      "2@mango.com"
    //    ],
    //    "url": "http://4talk.com",
    //    "note": "NOTE NOTE"
    //  }
    //}
}
