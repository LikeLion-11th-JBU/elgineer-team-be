package com.elgineer.hackertonelgineer.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LifeCategoryController {
    @GetMapping("/lifecategory")
    public String lifemain() {
        return "lifecategory.html"; 
    }
    @GetMapping("/lifecategory/together") // 노인주거복지제도, 관련 신청서 지역별로 있음
    public String together(){
        return "lifecategory/together.html";
    }
    @GetMapping("/lifecategory/together/info")
    public String togetherinfo(){ return "redirect:https://easylaw.go.kr/CSP/CnpClsMainBtr.laf?popMenu=ov&csmSeq=673&ccfNo=4&cciNo=1&cnpClsNo=1";}

    @GetMapping("/lifecategory/guarantee") // 기초생활보장제도
    public String guarantee(){
        return "lifecategory/guarantee.html";
    }

    @GetMapping("/lifecategory/guarantee/info")
    public String guaranteeinfo(){ return "redirect:https://www.mohw.go.kr/react/policy/index.jsp?PAR_MENU_ID=06&MENU_ID=063501";}

    @GetMapping("/lifecategory/guarantee/application")
    public String guaranteeApp() { return "redirect:https://www.seongnam.go.kr/contents/down/health/10961_12.pdf";}
    @GetMapping("/lifecategory/pension") // 기초연금
    public String pension(){
        return "lifecategory/pension.html";
    }

    @GetMapping("/lifecategory/pension/info")
    public String pensioninfo(){ return "redirect:https://basicpension.mohw.go.kr/menu.es?mid=a10201000000";}

    @GetMapping("/lifecategory/pension/application")
    public String pensionApp() {return "redirect:https://law.go.kr/LSW/flDownload.do?flSeq=102256231&flNm=%5B%EB%B3%84%EC%A7%80+%EC%A0%9C1%ED%98%B8%EC%84%9C%EC%8B%9D%5D+%EA%B8%B0%EC%B4%88%EB%85%B8%EB%A0%B9%EC%97%B0%EA%B8%88%EC%A7%80%EA%B8%89%EC%8B%A0%EC%B2%AD%EC%84%9C%0A";}

    @GetMapping("/lifecategory/work") // 노인일자리지원 사업 , 신청방법은 지역내 관련 기관에 문의해야함.
    public String work(){
        return "lifecategory/work.html";
    }

    @GetMapping("lifecategory/work/info")
    public String workinfo() { return "redirect:https://www.mohw.go.kr/react/policy/index.jsp?PAR_MENU_ID=06&MENU_ID=06390201&PAGE=1&topTitle=%EB%85%B8%EC%9D%B8%20%EC%9D%BC%EC%9E%90%EB%A6%AC%20%EB%B0%8F%20%EC%82%AC%ED%9A%8C%ED%99%9C%EB%8F%99%20%EC%A7%80%EC%9B%90%20%EC%82%AC%EC%97%85";}


    @GetMapping("/lifecategory/care") // 노인 맞춤돌봄 서비스
    public String care(){
        return "lifecategory/care.html";
    }

    @GetMapping("/lifecategory/care/info")
    public String careinfo() { return "redirect:https://www.mohw.go.kr/react/policy/index.jsp?PAR_MENU_ID=06&MENU_ID=06390104&PAGE=4&topTitle=";}


    @GetMapping("/lifecategory/alarm") // 노인 응급안전안심 서비스
    public String alarm(){
        return "lifecategory/alarm.html";
    }

    @GetMapping("/lifecategory/alarm/info")
    public String alarminfo() { return "redirect:https://www.bokjiro.go.kr/ssis-tbu/twataa/wlfareInfo/moveTWAT52011M.do?wlfareInfoId=WLF00001093";}



}

// 카카오맵, 신청서, 접수방법

