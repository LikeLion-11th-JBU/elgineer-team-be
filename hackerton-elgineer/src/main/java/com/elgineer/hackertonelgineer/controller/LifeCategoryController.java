package com.elgineer.hackertonelgineer.controller;




import com.elgineer.hackertonelgineer.entity.LifeCategory;
import com.elgineer.hackertonelgineer.service.LifeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.List;

@Controller
public class LifeCategoryController {
    @Autowired
    private LifeCategoryService categoryService;

    @GetMapping("/lifecategory")
    public String lifemain(Model model) {
        List<LifeCategory> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "lifecategory.html"; // lifecategory.html을 템플릿으로 사용합니다.
    }

    @GetMapping("/lifecategory/lifewelfare")
    public String lifewelfare(Model model){


        return "welfare.html";
    }

    @GetMapping("/crawl")
    @ResponseBody
    public String crawlGoogle() {
        // 여기서 크롤링 코드를 실행합니다.
        // 셀레니움과 Jsoup을 사용하여 구글에서 검색 결과를 크롤링하고 나열하는 작업을 수행합니다.

        // 크롤링한 결과를 문자열로 반환합니다.
        return "Crawling Result";
    }
}
