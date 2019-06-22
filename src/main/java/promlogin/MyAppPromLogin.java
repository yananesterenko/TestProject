package promlogin;

import promlogin.services.CreatePromLogin;

public class MyAppPromLogin {
    public static void main(String[] args) {
        String timeMillis = String.valueOf(System.currentTimeMillis());
        String email = "tt" + timeMillis + "@gmail.com";
        CreatePromLogin.createLogin("name_25", email, "123456Tt" );
    }
}
