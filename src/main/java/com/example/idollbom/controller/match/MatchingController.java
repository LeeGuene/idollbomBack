package com.example.idollbom.controller.match;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.matchservice.MatchingService;
import com.example.idollbom.service.myPageservice.parentservice.noteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final ParentMapper parentMapper;
    private final noteService noteService;

    // 자동매칭 들어가는 첫 화면
    @GetMapping
    public String match(Model model) {

        // 부모 parentNumber, role 및 쪽지 목록 개수를 view에 전달하는 코드 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {
            CustomUserDTO parent_info = ((CustomUserDTO) authentication.getPrincipal());
            String parentId = parent_info.getEmail();

            ParentVO parent = parentMapper.selectOne(parentId);

            int count = noteService.countParentNoteList(parent.getParentNumber());

            model.addAttribute("count", count);
            model.addAttribute("role", parent.getRole());
            model.addAttribute("parentNumber", parent.getParentNumber());
        }

        return "/html/match/matching";
    }
}
