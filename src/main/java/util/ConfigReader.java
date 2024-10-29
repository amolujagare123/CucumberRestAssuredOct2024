package util;

import java.util.ResourceBundle;

public class ConfigReader {



    public static String getBaseUrl()
    {
        return  ResourceBundle.getBundle("config").getString("baseUrl");
    }
}
