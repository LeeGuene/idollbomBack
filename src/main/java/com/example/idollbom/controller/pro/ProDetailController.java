package com.example.idollbom.controller.pro;

import com.example.idollbom.domain.dto.parentdto.ReviewListDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.mapper.applymapper.ClassReviewMapper;
import com.example.idollbom.service.applyservice.ClassReviewService;
import com.example.idollbom.service.proservice.ProDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class ProDetailController {

    private final ProDetailService proDetailService;
    private final ClassReviewService classReviewService;

    // 전문가 프로필 상세보기 페이지 ( 이미지, 이름, 프로필 이미지 )
    // 하단에 전문가 수업에 달린 모든 리뷰 목록 표시
    @GetMapping("/detail")
    public String detail(@RequestParam("proNumber") Long proNumber,
                         @RequestParam("classNumber") Long classNumber,
                         Model model) {
        
        // 전문가 정보 조회 ( by proNumber(pk) )
        ProDetailDTO pro_info = proDetailService.findDetailByNumber(proNumber);
            
        // 특정 전문가 수업에 대한 전체 리뷰 조회
        List<ReviewListDTO> reviews = classReviewService.findAllReviewList(classNumber);
        
        model.addAttribute("pro_info", pro_info);
        model.addAttribute("reviews", reviews);

        return "/html/parent/review";
    }

}
