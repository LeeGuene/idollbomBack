package com.example.idollbom.controller.myPage;
import com.example.idollbom.domain.dto.prodto.proReportDTO;
import com.example.idollbom.domain.vo.ProPostVO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.domain.vo.classVO;
import com.example.idollbom.service.myPageservice.proservice.classService;
import com.example.idollbom.service.proService.ProDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
//  내 수업목록 보기
    @GetMapping("/proClass")
    public String selectProClass(Model model){
        List<classVO> classVO = classService.selectMyClass(6L);
        model.addAttribute("class",  classVO );
        return "html/myPage/pro/class";
    }

//  내 신고목록 보기
    @GetMapping("/report")
    public String selectReport(Model model){
        List<proReportDTO> proReportVOS = classService.selectReport(6L);
        model.addAttribute("report",  proReportVOS );
        return "html/myPage/pro/hateUser";
    }

//  내 게시글 보기
    @GetMapping("/MyPost")
    public String selectMyPost(Model model){
        List<ProPostVO> proPostVOS = proDetailService.selectProPost(6L);
        model.addAttribute("posts",  proPostVOS );
        return "html/myPage/pro/Post";
    }

// 내 프로필 보기
    @GetMapping("/profile")
    public String selectProfile(Model model){
        ProVO proPrivate = proDetailService.selectProPrivate(6L);
        model.addAttribute("pro", proPrivate);
        return "html/myPage/pro/profile";
    }

    @GetMapping("/calender")
    public String selectCalender(){
        return "html/myPage/pro/calender";
    }

}
