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
import org.springframework.web.bind.annotation.*;

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
    public String signup() {
        log.info("로그인으로 이동");
        return "html/login/registerpage";
    }

//  부모 회원가입폼 제출
    @PostMapping("/signup")
        public String signup(ParentDTO dto) {
        log.info("HTML에서 넘어온 데이터: " + dto.toString());

        parentService.save(dto);
        return "/html/mypage/parent/myPost";
}


//  로그아웃화면 이동
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/user/login";
    }

}
