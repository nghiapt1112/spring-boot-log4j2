package com.nghia.ivector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public String fwUserProfilePage(Model model) {
        return "user/profile";
    }

    @GetMapping("role")
    public String fwPermissionPage() {
        return "user/permission";
    }

    @PostMapping("/profile")
    public String saveProfile() {
        return "";
    }


}
