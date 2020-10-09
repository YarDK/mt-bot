import org.testng.annotations.Test;

public class TestRegister extends TestBase {

    @Test
    public void testRegister(){
        System.out.println("TestRegister done!");
    }

    @Test(enabled = false)
    public void testRegisterEmail(){
        app.session().unregister();
        System.out.println("Wait 31 second...");
        app.waiter(31000);
        app.session().credentials();
        app.session().registration();
        System.out.println("TestRegister with Email done!");
    }


}
