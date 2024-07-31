package com.example.idollbom.controller.match;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.matchservice.MatchingService;
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

    // 자동매칭 들어가는 첫 화면
    @GetMapping
    public String match(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {
            CustomUserDTO parent_info = ((CustomUserDTO) authentication.getPrincipal());
            String parentId = parent_info.getEmail();

            ParentVO parent = parentMapper.selectOne(parentId);

            // model.addAttribute("parentName", parent.getParentName());
            model.addAttribute("role", parent.getRole());
            model.addAttribute("parentNumber", parent.getParentNumber());
        }else{
            model.addAttribute("parentName", "Guest");
            model.addAttribute("role", "Guest");
        }

        return "/html/match/matching";
    }
}
