package ApplicationManager;

import Models.RegisterData;
import Requests.*;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class MainApplication extends MainMethods{

    private RegisterData registerData;
    private CallHistoryRequests callHistoryRequests;
    private ChatRequests chatRequests;
    private ContactRequest contactRequest;
    private ProfileRequests profileRequests;
    private SessionsRequests sessionsRequests;

    public void init(String environment) {
        System.out.println(String.format("ENVIRONMENT - Tests running on environment: %s\n",environment));
        registerData = new RegisterHelper().registerData(environment);
        sessionsRequests = new SessionsRequests(registerData);
        sessionsRequests.authorisation();
        sessionsRequests.registration();
        sessionsRequests.startSession();

        callHistoryRequests = new CallHistoryRequests(registerData);
        chatRequests = new ChatRequests(registerData);
        contactRequest = new ContactRequest(registerData);
        profileRequests = new ProfileRequests(registerData);

    }

    public void stop(){
        sessionsRequests.unregister();
    }

    public RegisterData data(){
        return registerData;
    }

    public SessionsRequests session(){
        return sessionsRequests;
    }

    public CallHistoryRequests callHistory(){
        return callHistoryRequests;
    }

    public ChatRequests chat(){
        return chatRequests;
    }

    public ContactRequest contact(){
        return contactRequest;
    }

    public ProfileRequests profile(){
        return profileRequests;
    }

}
