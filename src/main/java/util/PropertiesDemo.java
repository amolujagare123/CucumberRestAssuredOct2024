package util;

import java.util.ResourceBundle;

public class PropertiesDemo {

    public static void main(String[] args) {

        ResourceBundle rb = ResourceBundle.getBundle("config");
        System.out.println(rb.getString("baseUrl"));
    }

}
