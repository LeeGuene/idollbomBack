package com.example.idollbom.controller.customservice.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ask")
@RequiredArgsConstructor
public class AskController {

    // 문의하기 페이지 불러오기
    @GetMapping()
    public String ask() {
        return "/html/customerService/question/question";
    }
}
