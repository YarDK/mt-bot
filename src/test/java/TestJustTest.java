import Models.RegisterData;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TestJustTest extends TestBase {


    @Test
    public void testTest1() {
        int case_id = 0;

        RegisterData data = app.data();
        String auth_token = data.getAuth_token();
        String refresh_token = data.getRefresh_token();
        String url = data.getUrl_auth() + "/auth/ticket/step1";
        System.out.println("url:\n" + url);
        String post_request = RestAssured.given()
                .parameter("auth_token", auth_token)
                .parameter("refresh_token", refresh_token)
                .post(url).asString();

        System.out.println(post_request);
        // Response
        // {"result":1000,"ticket":"00232fcdc3c3ee93240a1292265f4aabb0a9cdb073db1475378dadf91d89911b"}
        // https://issa7-prerelease-ru.by.mgo.su/?redirect_controller=product&redirect_action=vats&auth_ticket=00232fcdc3c3ee93240a1292265f4aabb0a9cdb073db1475378dadf91d89911b
    }

    @Test
    public void test2(){

    }



}
