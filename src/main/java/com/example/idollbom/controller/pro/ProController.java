package com.example.idollbom.controller.pro;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.service.loginservice.ProService;
import com.example.idollbom.service.myPageservice.parentservice.noteService;
import com.example.idollbom.service.proService.ChildFindService;
import com.example.idollbom.service.proService.ProDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pro")
@Slf4j
public class ProController {

    private final ProDetailService proDetailService;
    private final ChildFindService childFindService;
    private final ProService proService;
    private final noteService noteService;

    // 1. 메인 페이지에서 전문가 프로필 클릭해서 넘어옴
    // 2. 수업 상세보기에서 프로필 보기를 통해 넘어옴
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

    // 아이찾기 내 모든 나의 수업을 찜한 부모 목록 보여주기
    @GetMapping("/childlist")
    public String goChildFind(@RequestParam(value = "proNumber") Long proNumber,
                              @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
                              Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {

            CustomUserDTO pro = ((CustomUserDTO) authentication.getPrincipal());
            String proId = pro.getEmail();

            ProVO pro_info = proService.selectPro(proId);

            String role = pro_info.getRole();
            // 쪽지 목록 개수 카운트
            int count = noteService.countProNoteList(pro_info.getProNumber());

            System.out.println(role);

            model.addAttribute("proNumber", pro_info.getProNumber());
            model.addAttribute("count", count);
            model.addAttribute("role", role);
        }

        // 페이징 처리 코드
        int count = childFindService.classSaveCount(proNumber);
        int totalPages = (int) Math.ceil((double) count / pageSize);

        List<ChildFindDTO> saveList = childFindService.findAllParent(proNumber, pageNo, pageSize);

        log.info("쿼리문으로 받아온 데이터 : ");
        saveList.stream().map(ChildFindDTO::toString).forEach(log::info);

        int pageGroupSize = 2;
        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        // 전문가 정보 넘기는 테스트 코드
        Long proNubmer = proDetailService.findProInfo(proNumber).getProNumber();
        log.info("전문가 pk : " + proNumber);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("proNumber", proNubmer);
        model.addAttribute("saveList", saveList);

        // 4. 시작 페이지 수 5. 마지막 페이지 수
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/html/pro/childfind";
    }
}
