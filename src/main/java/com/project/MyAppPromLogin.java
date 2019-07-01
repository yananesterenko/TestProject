package com.project;

import com.project.services.PromLoginService;

public class MyAppPromLogin {
    public static void main(String[] args) {
        String timeMillis = String.valueOf(System.currentTimeMillis());
        String email = "tt" + timeMillis + "@gmail.com";
        PromLoginService.createLogin("name_25", email, "123456Tt");
    }
}
