package com.elgineer.hackertonelgineer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCategoryController {

    // 복지 목록
    @GetMapping("/healthhome")
    public String healthHome(){
        return "healthhome";
    }

    // 치매 목록
    @GetMapping("/healthhome/dementia")
    public String dementia(){
        return "healthdementia";
    }

    // 치매 관련 정보
    @GetMapping("/healthhome/dementia/question")
    public String question(){
        return "redirect:https://easylaw.go.kr/CSP/CnpClsMain.laf?popMenu=ov&csmSeq=854&ccfNo=2&cciNo=4&cnpClsNo=1&search_put=";
    }

    // 우리동네자조모임 찾기
    @GetMapping("/healthhome/dementia/find")
    public String find(){
        return "redirect:https://m.nid.or.kr/support/jajo_group.aspx?RC=020000005";
    }

    // 위치 찾기
    @GetMapping("/healthhome/map")
    public String map(){
        return "healthmap";
    }

    // 노인 장기 요양 보험 복지
    @GetMapping("/healthhome/recuperation")
    public String recuperation(){
        return "healthrecuperation";
    }

    // 노인 장기 요양 보험 복지 관련 내용
    @GetMapping("/healthhome/recuperation/question")
    public String recuperationQuestion(){
        return "redirect:https://m.blog.naver.com/care-together/222200053497";
    }

    // 노인 장기 요양 신청하기
    @GetMapping("/healthhome/recuperation/download")
    public String recuperationDownload(){
        return "redirect:https://www.longtermcare.or.kr/npbs/u/b/101/openLtcRcgtAplyPttnChoice.web?aplyTypeScr=appltit&menuId=npe0000000500";
    }

    // 노인 운동 강화 복지
    @GetMapping("/healthhome/exercise")
    public String exercise(){
        return "healthexercise";
    }

    // 노인 운동 강화 복지 관련 정보
    @GetMapping("/healthhome/exercise/question")
    public String exerciseQuestion(){
        return "redirect:https://www.nhis.or.kr/static/alim/paper/oldpaper/202207/sub/19.html";
    }

    // 노인 운동 강화 복지 신청서 다운로드
    @GetMapping("/healthhome/exercise/download")
    public String exerciseDownload(){
        return "redirect:https://www.50plus.or.kr/upload/im/2022/04/404d7a48-d959-4ae4-be32-a7005a166270.pdf";
    }

    @GetMapping("/healthhome/implant")
    public String implant(){
        return "healthimplant";
    }

    // 노인 틀니 및 인플란트 복지 정보
    @GetMapping("/healthhome/implant/question")
    public String implantQuestion(){
        return "redirect:https://newswp.net/%ec%9e%84%ed%94%8c%eb%9e%80%ed%8a%b8%ed%8b%80%eb%8b%88/";
    }

    // 무릎관련 수술비 지원 복지
    @GetMapping("/healthhome/surgery")
    public String surgery(){
        return "healthsurgery";
    }

    // 무릎관련 수술비 지원 복지 정보
    @GetMapping("/healthhome/surgery/question")
    public String surgeryQuestion(){
        return "redirect:https://www.ok6595.or.kr/client/info/knee02.asp";
    }

    // 무릎관련 수술비 지원 복지 신청서
    @GetMapping("/healthhome/surgery/download")
    public String surgeryDownload(){
        return "redirect:https://www.gn.go.kr/phc/gonet/FileDownload.do?fileName=sub03_06_05_file.hwp&code=download/phc/";
    }

    // 노인 예방 접종 복지
    @GetMapping("/healthhome/vaccination")
    public String vaccination(){
        return "healthvaccination";
    }

    // 노인 예방 접종 안내
    @GetMapping("/healthhome/vaccination/question")
    public String vaccinationQuestion(){
        return "redirect:https://jasilvercare.com/%EB%85%B8%EC%9D%B8-%ED%95%84%EC%88%98-%EC%98%88%EB%B0%A9%EC%A0%91%EC%A2%85-%EC%95%88%EB%82%B4/";
    }


}
