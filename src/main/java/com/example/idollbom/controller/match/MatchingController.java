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

    // 처음 들어가는 화면
    @GetMapping()
    public String match() {
        return "/html/match/matching";
    }

    // 검색 버튼을 눌렀을 때
    @GetMapping("/submit")
    public String submit(@RequestParam(value = "category", defaultValue = "돌봄") String category,
                         @RequestParam(value = "data", defaultValue = "등/하원") String data,
                         @RequestParam(value = "dateTime", required = false) String dateTime,
                         @RequestParam(value = "time", defaultValue = "14") String time,
                         Model model) {

        // 검색버튼을 누르면 입력한 데이터와 비교하여 조건과 일치하는 수업을 가져옴
        List<MatchingDTO> match = matchingService.matchClass(category, data, dateTime, time);

        System.out.println("==============================="  + category);
        System.out.println("==============================="  + data);
        System.out.println("==============================="  + dateTime);
        System.out.println("==============================="  + time);

        model.addAttribute("matches", match);
        return "/html/match/matching";
    }
}
