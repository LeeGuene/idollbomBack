package com.example.idollbom.controller.match;

import com.example.idollbom.service.matchservice.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submit")
@RequiredArgsConstructor
public class MatchingRestController {

    private final MatchingService matchingService;

    // 검색버튼을 눌렀을 때 뿌려주는 전문가 매칭 정보

    // 리턴은 데이터를 뿌려주면 된다.

}
