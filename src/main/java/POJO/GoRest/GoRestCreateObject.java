package POJO.GoRest;

public class GoRestCreateObject {

    public static  GoRestCreateUserPojo getGoRestCreateObject(String name,String email,String gender,String status)
    {
        GoRestCreateUserPojo ob = new GoRestCreateUserPojo();
        ob.setName(name);
        ob.setEmail(email);
        ob.setGender(gender);
        ob.setStatus(status);

        return ob;
    }
}
