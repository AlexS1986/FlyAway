package com.schlueter.flyaway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/overview")
    public String adminOverview() {
        return "admin/adminOverview";
    }

    // Add other mappings for airlines/list, airports/list, etc.
    // You will need corresponding templates and controller methods for each section.
}
