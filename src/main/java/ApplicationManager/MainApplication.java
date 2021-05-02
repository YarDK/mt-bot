package ApplicationManager;

import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    protected static RunnerApplication runner = new RunnerApplication();

    public void setUp(){
        runner.init(System.getProperty("environment","prod"));
    }

    public void tearDown(){
        runner.stop();
    }

    public static void main(String[] args) {
        MainApplication app = new MainApplication();
        PollEventsListener listener = new PollEventsListener();

        app.setUp();
        listener.Listener();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String command = reader.readLine();
                if(command.equals("stop")){
                    app.tearDown();
                    break;
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
