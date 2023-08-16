package com.elgineer.hackertonelgineer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EduCategoryController {

    //스마트폰 글자 크기 조절 목록
    @GetMapping("/smartphone_text_size")
    public String smartphoneTextSizePage() {
        return "smartphone_text_size";
    }

    //스마트폰 화면 밝기 조절 목록
    @GetMapping("/smartphone_brightness")
    public String smartphoneBrightnessPage() {
        return "smartphone_brightness";
    }

    //스마트폰 배경화면 변경 목록
    @GetMapping("/smartphone_background")
    public String smartphoneBackgroundPage() {
        return "smartphone_background";
    }

    //스마트폰 알람 설정 목록
    @GetMapping("/smartphone_alarm")
    public String smartphoneAlarmPage() {
        return "smartphone_alarm";
    }

    //카카오톡 글자 크기 조절 목록
    @GetMapping("/kakao_text_size")
    public String kakaoTextSizePage() {
        return "kakao_text_size";
    }

    //카카오택시 호출 방법 목록
    @GetMapping("/kakao_taxi")
    public String kakaoTaxiPage() {
        return "kakao_taxi";
    }

    //키오스크 체험하기 목록
    @GetMapping("/kiosk_experience")
    public String kioskExperiencePage() {
        return "kiosk_experience";
    }

}
