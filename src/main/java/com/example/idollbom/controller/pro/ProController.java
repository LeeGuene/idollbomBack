package com.example.idollbom.controller.pro;

import com.example.idollbom.domain.dto.parentdto.ReviewAllListDTO;
import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.applyservice.ClassReviewService;
import com.example.idollbom.service.proService.ChildFindService;
import com.example.idollbom.service.proService.ProDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pro")
@Slf4j
public class ProController {

    private final ProDetailService proDetailService;
    private final ChildFindService childFindService;

    // 전문가 프로필 상세보기 페이지 ( 이미지, 이름, 프로필 이미지 )
    // 하단에 전문가 수업에 달린 모든 리뷰 목록 표시
    @GetMapping("/detail")
    public String proDetail(@RequestParam(value="proNumber") Long proNumber,
                         Model model) {

        // 특정 전문가 프로필 상세보기 조회
        ProDetailDTO pro_info = proDetailService.findProDetailByNumber(proNumber);

        // 특정 전문가의 전체 리뷰 조회
        List<ProReviewListDTO> reviews = proDetailService.findAllReviewList(proNumber);

        model.addAttribute("pro_info", pro_info);
        model.addAttribute("reviews", reviews);

        return "/html/parent/review";
    }

    @GetMapping("/find/{proNumber}")
    public String find(@PathVariable("proNumber") Long proNumber,
                       Model model){

        List<ChildFindDTO> saveList = childFindService.findAllParent(proNumber);

        saveList.stream().map(ChildFindDTO::toString).forEach(log::info);

        model.addAttribute("saveList", saveList);

        return "/html/pro/childfind";
    }

}
