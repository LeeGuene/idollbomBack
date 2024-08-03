package com.example.idollbom.controller.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/procommunity")
@RequiredArgsConstructor
public class ProcommunityController {

    // 전문가 페이지이동 컨트롤러
    @GetMapping()
    public String procommunity() {
        return "/html/board/pro/community_pro";
    }


}
