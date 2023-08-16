package com.elgineer.hackertonelgineer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EduCategoryController {
    @GetMapping("/edu")
    public String edu() {return "edu.html";}

    @GetMapping("/edu1")
    public String edu1() {return "edu1.html";}

    @GetMapping("/edu2")
    public String edu2() {return "edu2.html";}

    @GetMapping("/edu3")
    public String edu3() {return "edu3.html";}

    @GetMapping("/edu4")
    public String edu4() {return "edu4.html";}

    @GetMapping("/edu5")
    public String edu5() {return "edu5.html";}

    @GetMapping("/edu6")
    public String edu6() {return "edu6.html";}

    @GetMapping("/edu7")
    public String edu7() {return "edu7.html";}
}
