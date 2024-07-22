package com.example.idollbom.controller.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proMain")
@Slf4j
public class ProMainController {
    
    // 전문가 메인 페이지로 이동하면서 proNumber 넘겨주기
    @GetMapping
    public String proMain() {

        return "/html/main/index_pro.html";
    }

}
