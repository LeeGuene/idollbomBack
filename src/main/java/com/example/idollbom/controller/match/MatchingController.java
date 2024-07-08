package com.example.idollbom.controller.match;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/match")
@RequiredArgsConstructor
@Slf4j
public class MatchingController {
    // 처음 들어가는 화면
    @GetMapping()
    public String match() {
        return "/html/match/matching";
    }
}
