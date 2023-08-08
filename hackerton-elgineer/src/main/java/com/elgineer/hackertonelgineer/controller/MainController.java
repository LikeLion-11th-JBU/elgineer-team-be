package com.elgineer.hackertonelgineer.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/")
    public String main(){
        return "index.html";
    }

    @GetMapping("/lifecategory")
    public String lifemain() {

        return "lifecategory.html"; // lifecategory.html을 템플릿으로 사용합니다.
    }

    @GetMapping("/educategory")
    public String edumain(){
        return "edu.html";
    }

    @GetMapping("/healthcategory")
    public String heealthmain(){
        return "health.html";
    }
}
