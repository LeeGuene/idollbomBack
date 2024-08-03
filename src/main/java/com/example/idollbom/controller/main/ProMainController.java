package com.example.idollbom.controller.main;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.service.loginservice.ProService;
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
@RequestMapping("/promain")
@RequiredArgsConstructor
@Slf4j
public class ProMainController {

    private final ProService proService;
    private final noteService noteService;

    // 전문가 메인 페이지로 이동하면서 proNumber 넘겨주어야 함.
    @GetMapping
    public String proMain(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {
            CustomUserDTO pro = ((CustomUserDTO) authentication.getPrincipal());
            String proId = pro.getEmail();

            ProVO pro_info = proService.selectPro(proId);

            Long proNumber = pro_info.getProNumber();
            String role = pro_info.getRole();
            String proName = pro_info.getProName();

            int count = noteService.countProNoteList(proNumber);

            System.out.println(proNumber);
            System.out.println(role);

            model.addAttribute("count", count);
            model.addAttribute("proName", proName);
            model.addAttribute("role", role);
            model.addAttribute("proNumber", proNumber);
        }

        return "/html/main/index_pro.html";
    }

}
