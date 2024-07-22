package com.example.idollbom.controller.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promain")
@Slf4j
public class ProMainController {

    @GetMapping
    public String proMain() {
        return "/html/main/index_pro.html";
    }

}
