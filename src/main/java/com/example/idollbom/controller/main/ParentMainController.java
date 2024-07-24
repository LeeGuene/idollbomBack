package com.example.idollbom.controller.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parentmain")
@Slf4j
public class ParentMainController {

    //   부모 메인페이지로 이동
    @GetMapping
    public String parentmain(){
        return "/html/main/index_parents.html";
    }

    // 전문가 정보 리스트 페이지로 이동
    @GetMapping("/prolist")
    public String goProList(){

        return "/html/parent/prolist";
    }

}
