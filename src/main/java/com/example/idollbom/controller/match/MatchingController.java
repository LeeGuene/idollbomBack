package com.example.idollbom.controller.match;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import com.example.idollbom.service.matchservice.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.ValueExp;
import java.util.List;

@Controller
@RequestMapping("/match")
@RequiredArgsConstructor
@Slf4j
public class MatchingController {

    private final MatchingService matchingService;

    // 자동매칭 들어가는 첫 화면
    @GetMapping
    public String match() {
        return "/html/match/matching";
    }
}
