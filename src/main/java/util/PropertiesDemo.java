package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

       /* ResourceBundle rb = ResourceBundle.getBundle("config");
        System.out.println(rb.getString("baseUrl"));*/

        // 1.get the path of file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        // 2. create the object of Properties class
        Properties prop = new Properties();

        // 3. load prop object with file object
        prop.load(fis);

        // 4. get the value of the key
        System.out.println(prop.getProperty("baseUrl"));
    }

}
