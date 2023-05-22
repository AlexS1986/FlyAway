package com.schlueter.flyaway.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/home")
public class HomepageController {
    @GetMapping("/home")
    public String getHomepage(@RequestParam(value = "err", required = false) String err) {
        return "homepage";
    }
}
