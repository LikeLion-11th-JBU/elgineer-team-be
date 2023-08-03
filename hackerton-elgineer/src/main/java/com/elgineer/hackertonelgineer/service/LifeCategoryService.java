package com.elgineer.hackertonelgineer.service;

import com.elgineer.hackertonelgineer.dto.LifeCategoryDto;
import com.elgineer.hackertonelgineer.entity.LifeCategory;
import com.elgineer.hackertonelgineer.repository.LifeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LifeCategoryService {

    @Autowired
    private LifeCategoryRepository lifecategoryRepository;

    public List<LifeCategory> getAllCategories() {
        return lifecategoryRepository.findAll();
    }



}
