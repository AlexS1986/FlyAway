package com.schlueter.flyaway.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String adminOverview() {
        return "admin/adminOverview";
    }

    // Add other mappings for airlines/list, airports/list, etc.
    // You will need corresponding templates and controller methods for each section.
}
