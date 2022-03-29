package com.in28minutes.springbootfirstwebapplication.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateUser(String username, String password) {
        return username.equalsIgnoreCase("in28Minutes") && password.equalsIgnoreCase("password");
    }
}
