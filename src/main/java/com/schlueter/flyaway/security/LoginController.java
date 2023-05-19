package com.schlueter.flyaway.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showMyLoginPage() {
        return "login/login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "login/access-denied";
    }
}
