package com.elgineer.hackertonelgineer.controller;




import com.elgineer.hackertonelgineer.entity.LifeCategory;
import com.elgineer.hackertonelgineer.service.LifeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LifeCategoryController {




    @GetMapping("/lifecategory/together")
    public String together(){
        return "together.html";
    }

    @GetMapping("/lifecategory/guarantee")
    public String guarantee(){
        return "guarantee.html";
    }

    @GetMapping("/lifecategory/pension")
    public String Pension(){
        return "pension.html";
    }

    @GetMapping("/lifecategory/work")
    public String work(){
        return "work.html";
    }



    @GetMapping("/lifecategory/care")
    public String care(){
        return "care.html";
    }

    @GetMapping("/lifecategory/alarm")
    public String alarm(){
        return "alarm.html";
    }



}

// 카카오맵, 신청서, 접수방법

//        return "redirect:https://www.goodhosrank.com/hospital/hospital_list.php?gubun=%EC%9A%94%EC%96%91%EB%B3%91%EC%9B%90&addcode=11&department=&hostime=&orderby=&hostime2=&pagenum=1&linenum=&stationid=0"; 요양병원
//         return "redirect:https://easylaw.go.kr/CSP/CnpClsMainBtr.laf?popMenu=ov&csmSeq=673&ccfNo=4&cciNo=1&cnpClsNo=1"; 노인거주 복지시설