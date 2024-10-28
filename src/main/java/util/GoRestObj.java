package util;

import POJO.GoRest.GoRestCreateUserPojo;

public class GoRestObj {


    public static GoRestCreateUserPojo getCreateUserGoRestPayLoad(String name, String email, String gender, String status)
    {
        GoRestCreateUserPojo ob = new GoRestCreateUserPojo();

        ob.setName(name);
        ob.setEmail(email);
        ob.setGender(gender);
        ob.setStatus(status);

        return ob;
    }
}
