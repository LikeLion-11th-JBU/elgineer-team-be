package com.elgineer.hackertonelgineer.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/")
    public String main(){
        return "index.html";
    }
}
