package com.example.idollbom.controller.pro;

import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.service.proService.ChildFindService;
import com.example.idollbom.service.proService.ProDetailService;
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
    
    // 아이찾기 내 모든 나의 수업을 찜한 부모 목록 보여주기
    // 테스트를 위해서 임의로 대메뉴 "아이찾기" 버튼에 직접 proNumber를 전달함. ( index_pro.html, header_pro.html에 모두 추가 )
    @GetMapping("/childlist/{proNumber}")
    public String goChildFind(@PathVariable("proNumber") Long proNumber,
                              @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
                              Model model){

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

        model.addAttribute("count", count);
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

    // 페이징 처리된 버튼을 클릭하면 proNumber를 @RequestParam으로 받아옴.
    @GetMapping("/childlist")
    public String pagingChildList(@RequestParam("proNumber") Long proNumber,
                                  @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
                                  Model model){

        log.info("페이지 버튼 클릭시 넘어온 데이터 : " + pageNo + ", " + pageSize + ", " + proNumber);

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

        model.addAttribute("count", count);
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
