package com.nghia.ivector.controller;

import com.nghia.ivector.domain.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ivector")
public class IVectorController {

    @GetMapping("/home")
    public String defaultPage2() {
        return "html/home";
    }

    @GetMapping("/profile")
    public String userProfile(Model model) {
        model.addAttribute("requestUser", new User());
        return "user/profile";
    }
}
