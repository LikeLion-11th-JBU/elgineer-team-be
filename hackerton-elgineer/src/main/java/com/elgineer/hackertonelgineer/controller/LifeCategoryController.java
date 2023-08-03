package com.elgineer.hackertonelgineer.controller;



import com.elgineer.hackertonelgineer.dto.LifeCategoryDto;
import com.elgineer.hackertonelgineer.entity.LifeCategory;
import com.elgineer.hackertonelgineer.service.LifeCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LifeCategoryController {
    @Autowired
    private LifeCategoryService categoryService;

    @GetMapping("/lifecategory")
    public String showCategories(Model model) {
        List<LifeCategory> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "lifecategory.html"; // lifecategory.html을 템플릿으로 사용합니다.
    }

}
