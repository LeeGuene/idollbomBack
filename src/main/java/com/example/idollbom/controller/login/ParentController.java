package com.example.idollbom.controller.login;

import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.service.loginservice.ParentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class ParentController {

    private final ParentService parentService;
//  부모 로그인화면이동
    @GetMapping("/login")
    public String login() {
        return "html/login/loginpage";

    }
//  부모 회원가입화면이동
    @GetMapping("/signup")
    public String signup(Model model) {
        ParentDTO dto = new ParentDTO(); // 예시로 객체 생성
        model.addAttribute("dto", dto); // "dto"라는 이름으로 모델에 객체 추가
        return "html/login/registerpage";
    }
//  부모 회원가입폼 제출
    @PostMapping("/signup")
    public String signup(@ModelAttribute("dto") ParentDTO dto) {
        log.info("html 넘어온 데이터!!!!!!!!!    " + dto.toString());
        parentService.save(dto);
        return "redirect:/user/login";
    }
//  부모 마이페이지 이동
    @GetMapping("/myPage")
    public String getMypage() {
        return "/html/mypage/parent/myPost";
    }
//  로그아웃화면 이동
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/user/login";
    }



}
