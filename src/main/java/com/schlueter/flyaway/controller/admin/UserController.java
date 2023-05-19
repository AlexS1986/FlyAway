package com.schlueter.flyaway.controller.admin;

import com.schlueter.flyaway.entity.User;
import com.schlueter.flyaway.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/password")
    public String showPasswordForm(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        PasswordWrapper password = new PasswordWrapper();
        model.addAttribute("password",password);
        return "admin/users/password";
    }

    @PostMapping("/password/save")
    public String saveUser(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("password") PasswordWrapper password) {
        User user = userService.findByUserName(userDetails.getUsername());
        userService.updatePasswordOfUser(user, password.getValue());

        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/showLoginPage?logout";
    }


}
