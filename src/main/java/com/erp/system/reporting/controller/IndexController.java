package com.erp.system.reporting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}