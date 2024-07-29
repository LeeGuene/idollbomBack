package com.example.idollbom.controller.myPage;
import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.prodto.proReportDTO;
import com.example.idollbom.domain.vo.ProPostVO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.domain.vo.classVO;
import com.example.idollbom.service.loginservice.ProService;
import com.example.idollbom.service.myPageservice.proservice.classService;
import com.example.idollbom.service.proService.ProDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proMyPage")
@RequiredArgsConstructor
@Slf4j
public class proMypageController {
    private final classService classService;
    private final ProDetailService proDetailService;
    private final ProService proService;

    // 현재 로그인한 전문가 pk 가져오는 메소드
    public Long proNumber(){
        // 현재 로그인한 전문가 pk 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDTO p = ((CustomUserDTO) authentication.getPrincipal());
        String proId = p.getEmail();

        ProVO pro = proService.selectPro(proId);
        System.out.println(pro.getProNumber());

        return pro.getProNumber();
    }


//  내 수업목록 보기
    @GetMapping("/proClass")
    public String selectProClass(Model model){
        Long proId = proNumber();

        List<classVO> classVO = classService.selectMyClass(proId);
        model.addAttribute("class",  classVO );
        return "html/myPage/pro/class";
    }

//  내 신고목록 보기
    @GetMapping("/report")
    public String selectReport(Model model){
        Long proId = proNumber();

        List<proReportDTO> proReportVOS = classService.selectReport(proId);
        model.addAttribute("report",  proReportVOS );
        return "html/myPage/pro/hateUser";
    }

//  내 게시글 보기
    @GetMapping("/MyPost")
    public String selectMyPost(Model model){
        Long proId = proNumber();

        List<ProPostVO> proPostVOS = proDetailService.selectProPost(proId);
        model.addAttribute("posts",  proPostVOS );
        return "html/myPage/pro/Post";
    }

// 내 프로필 보기
    @GetMapping("/profile")
    public String selectProfile(Model model){
        Long proId = proNumber();

        ProVO proPrivate = proDetailService.selectProPrivate(proId);
        model.addAttribute("pro", proPrivate);
        return "html/myPage/pro/profile";
    }

    @GetMapping("/calender")
    public String selectCalender(){
        return "html/myPage/pro/calender";
    }

}
