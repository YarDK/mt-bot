package ApplicationManager;

import Models.RegisterData;
import Models.TestrailData;
import Requests.*;

public class MainApplication extends MainMethods{

    private RegisterData registerData;
    private TestrailHelper testrailHelper;
    private CallHistoryRequests callHistoryRequests;
    private ChatRequests chatRequests;
    private ContactRequest contactRequest;
    private ProfileRequests profileRequests;
    private SessionsRequests sessionsRequests;
    private Autosecretary autosecretary;

    public void init(String environment) {
        System.out.printf("ENVIRONMENT - Tests running on environment: %s\n%n",environment);
        registerData = new RegisterHelper().registerData(environment);
        sessionsRequests = new SessionsRequests(registerData);
        sessionsRequests.authorisation();
        sessionsRequests.registration();
        sessionsRequests.startSession();

        callHistoryRequests = new CallHistoryRequests(registerData);
        chatRequests = new ChatRequests(registerData);
        contactRequest = new ContactRequest(registerData);
        profileRequests = new ProfileRequests(registerData);
        autosecretary = new Autosecretary(registerData);

        testrailHelper = new TestrailHelper();

    }


    public void stop(){
        sessionsRequests.unregister();
    }

    public RegisterData data(){
        return registerData;
    }

    public TestrailHelper testrail(){return testrailHelper;}

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

    public Autosecretary autosecretary(){
        return autosecretary;
    }

}
