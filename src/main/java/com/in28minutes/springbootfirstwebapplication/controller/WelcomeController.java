package com.in28minutes.springbootfirstwebapplication.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginMessage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    // public String sendWelcome(@RequestParam String name, @RequestParam String
    // password, ModelMap model) {
    // model.put("name", name);
    // boolean isValidUser = loginService.validateUser(name, password);
    // if (!isValidUser) {
    // model.put("errorMessage", "Invalid Credentials");
    // return "login";
    // }
    // model.put("name", name);
    // return "redirect:/";
    // }
}
