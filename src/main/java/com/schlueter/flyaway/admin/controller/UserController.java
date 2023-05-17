package com.schlueter.flyaway.admin.controller;

import com.schlueter.flyaway.admin.entity.Airline;
import com.schlueter.flyaway.admin.entity.Airport;
import com.schlueter.flyaway.admin.entity.Flight;
import com.schlueter.flyaway.admin.entity.User;
import com.schlueter.flyaway.admin.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/password")
    public String showPasswordForm(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username",userDetails.getUsername());
        return "admin/users/password";
    }

    @PostMapping("/password/save")
    public String saveUser(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("password") String password) {
        User user = userService.findByUserName(userDetails.getUsername());
        userService.updatePasswordOfUser(user, password);
        return "redirect:/logout";
    }


}
