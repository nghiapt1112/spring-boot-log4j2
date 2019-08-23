package com.nghia.ivector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping(value = {""})
    public String defaultHomePage() {
        return "left";
    }

}
