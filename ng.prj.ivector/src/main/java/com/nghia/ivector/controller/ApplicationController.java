package com.nghia.ivector.controller;

import com.nghia.ivector.domain.auth.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
//    SYSTEM
    @GetMapping(value = {"", "/"})
    public String defaultHomePage() {
        return "plain-page";
    }

    @GetMapping(value = {"/login"})
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

    // PAGE HI HI
    @GetMapping(value = {"/pricing"})
    public String toPricingTablePage() {
        return "pricing-table";
    }

    @GetMapping(value = {"/left"})
    public String defaultHomePageVersion2() {
        return "left";
    }


}
