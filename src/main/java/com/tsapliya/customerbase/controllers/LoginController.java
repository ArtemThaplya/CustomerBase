package com.tsapliya.customerbase.controllers;

import com.tsapliya.customerbase.login.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final ValidationService validationService;

    @Autowired
    public LoginController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("login") final String login,
                        @RequestParam("password") final String password) {
        boolean isAdmin = validationService.isAdmin(login, password);
        if (isAdmin) {
            return "menu.html";
        } else {
            return "error.html";
        }
    }
}
