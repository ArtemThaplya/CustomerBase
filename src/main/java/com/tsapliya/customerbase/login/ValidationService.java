package com.tsapliya.customerbase.login;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "root";

    public boolean isAdmin(String login, String password) {
        return ADMIN_LOGIN.equals(login) && ADMIN_PASSWORD.equals(password);
    }
}