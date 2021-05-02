import ApplicationManager.RunnerApplication;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {
    protected static RunnerApplication app = new RunnerApplication();



    @BeforeSuite
    public void setUp(){
        app.init(System.getProperty("environment","prod"));
        // Что бы отключить интеграцию с ТестРеил, надо закомментировать инициализацю ниже
        //app.testrail().init();
        //app.testrail().startRun();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
        //app.testrail().closeRun();
    }
}
