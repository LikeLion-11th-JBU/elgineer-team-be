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
    @GetMapping("/lifecategory/together/info")
    public String togetherinfo(){ return "redirect:https://easylaw.go.kr/CSP/CnpClsMainBtr.laf?popMenu=ov&csmSeq=673&ccfNo=4&cciNo=1&cnpClsNo=1";}

    @GetMapping("/lifecategory/guarantee")
    public String guarantee(){
        return "guarantee.html";
    }

    @GetMapping("/lifecategory/guarantee/info")
    public String guaranteeinfo(){ return "redirect:https://www.mohw.go.kr/react/policy/index.jsp?PAR_MENU_ID=06&MENU_ID=063501";}

    @GetMapping("/lifecategory/pension")
    public String pension(){
        return "pension.html";
    }

    @GetMapping("/lifecategory/pension/info")
    public String pensioninfo(){ return "https://basicpension.mohw.go.kr/menu.es?mid=a10201000000";}

    @GetMapping("/lifecategory/work")
    public String work(){
        return "work.html";
    }

    @GetMapping("lifecategory/work/info")
    public String workinfo() { return "redirect:https://www.mohw.go.kr/react/policy/index.jsp?PAR_MENU_ID=06&MENU_ID=06390201&PAGE=1&topTitle=%EB%85%B8%EC%9D%B8%20%EC%9D%BC%EC%9E%90%EB%A6%AC%20%EB%B0%8F%20%EC%82%AC%ED%9A%8C%ED%99%9C%EB%8F%99%20%EC%A7%80%EC%9B%90%20%EC%82%AC%EC%97%85";}


    @GetMapping("/lifecategory/care")
    public String care(){
        return "care.html";
    }

    @GetMapping("/lifecategory/care/info")
    public String careinfo() { return "redirect:https://www.mohw.go.kr/react/policy/index.jsp?PAR_MENU_ID=06&MENU_ID=06390104&PAGE=4&topTitle=";}

    @GetMapping("/lifecategory/alarm")
    public String alarm(){
        return "alarm.html";
    }

    @GetMapping("lifecategory/alarm/info")
    public String alarminfo() { return "redirect:https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001093";}


}

// 카카오맵, 신청서, 접수방법

//        return "redirect:https://www.goodhosrank.com/hospital/hospital_list.php?gubun=%EC%9A%94%EC%96%91%EB%B3%91%EC%9B%90&addcode=11&department=&hostime=&orderby=&hostime2=&pagenum=1&linenum=&stationid=0"; 요양병원
//         return "redirect:https://easylaw.go.kr/CSP/CnpClsMainBtr.laf?popMenu=ov&csmSeq=673&ccfNo=4&cciNo=1&cnpClsNo=1"; 노인거주 복지시설