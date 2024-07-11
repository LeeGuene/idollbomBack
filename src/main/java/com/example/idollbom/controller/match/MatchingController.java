package com.example.idollbom.controller.match;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import com.example.idollbom.service.matchservice.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/match")
@RequiredArgsConstructor
@Slf4j
public class MatchingController {

    private final MatchingService matchingService;

    // 처음 들어가는 화면
    @GetMapping()
    public String match(Model model) {
        MatchingDTO match = matchingService.matchClass();

        model.addAttribute("match", match);
        return "/html/match/matching";
    }

    // 검색 버튼을 눌렀을 때
    @GetMapping("/submit")
    public String submit(Model model) {
        MatchingDTO match = matchingService.matchClass();

        model.addAttribute("match", match);
        return "/html/match/matching";
    }
}
