package ApplicationManager;

import Models.RegisterData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class RegisterHelper{

    public RegisterData registerData(String environment) {
        Properties properties = new Properties();
        File file_properties = new File(String.format("src/main/resources/%s.properties", environment));
        try {
            properties.load(new FileReader(file_properties));
            return new RegisterData()
                    .withUsername(properties.getProperty("username"))
                    .withPassword(properties.getProperty("password"))
                    .withDevice_id(properties.getProperty("device_id"))
                    .withDevice_name(properties.getProperty("device_name"))
                    .withOs(properties.getProperty("os"))
                    .withDefault_status(properties.getProperty("default_status"))
                    .withTextStatus(properties.getProperty("textStatus"))
                    .withModel(properties.getProperty("model"))
                    .withApplication(properties.getProperty("application"))
                    .withUrl_auth(properties.getProperty("url.auth"))
                    .withUrl_4talk(properties.getProperty("url.4talk"))
                    .withUrl_mobigate(properties.getProperty("url.mobigate"))
                    .withUrl_apivks(properties.getProperty("url.apivks"))
                    .withUrl_clientapi(properties.getProperty("url.clientapi"))
                    .withUrl_fs(properties.getProperty("url.fs"))
                    .withUrl_ab(properties.getProperty("url.ab"));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
