package com.example.idollbom.controller.apply;

import com.example.idollbom.domain.dto.applydto.ClassDetailDTO;
import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.parentdto.ReservationInfoDTO;
import com.example.idollbom.domain.dto.parentdto.ReviewOneListDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.applyservice.ClassDetailService;
import com.example.idollbom.service.applyservice.ClassListService;
import com.example.idollbom.service.applyservice.ClassReviewService;
import com.example.idollbom.service.myPageservice.parentservice.noteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/class")
@RequiredArgsConstructor
@Slf4j
public class ClassListController {

    private final ClassListService classListService;
    private final ClassDetailService classDetailService;
    private final ClassReviewService classReviewService;
    private final noteService noteService;
    private final ParentMapper parentMapper;
    
    // 부모 role, parentNumber를 받아오는 메서드
    public void getRole(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {
            CustomUserDTO parent_info = ((CustomUserDTO) authentication.getPrincipal());
            String parentId = parent_info.getEmail();

            ParentVO parent = parentMapper.selectOne(parentId);

            // 부모 정보를 받아와서 쪽지목록 개수를 계산해서 html로 전달
            int count = noteService.countParentNoteList(parent.getParentNumber());

            model.addAttribute("noteCount", count);
            model.addAttribute("role", parent.getRole());
            model.addAttribute("parentNumber", parent.getParentNumber());
        }else{
            model.addAttribute("parentName", "Guest");
            model.addAttribute("role", "Guest");
        }
    }

    // 페이지 전부 페이징 처리 구현하기
    // 돌봄 페이지, default는 등하원으로
    @GetMapping("/classcare")
    public String classCare(@RequestParam(value = "category", defaultValue = "등/하원") String category,
                            @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                            Model model) {

        getRole(model);

        model.addAttribute("category", category);

        // 페이징 처리를 위한 코드
        int count = classListService.classCount(category);
        int totalPages = (int) Math.ceil((double) count / pageSize);

        List<ClassListDTO> classListDTO = classListService.findAllClass(category, pageNo, pageSize);

        System.out.println(classListDTO);

        int pageGroupSize = 3;
        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        System.out.println("Category: " + category);  // 로그 출력

        model.addAttribute("count", count);
        model.addAttribute("classLists", classListDTO);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);

        // 4. 시작 페이지 수 5. 마지막 페이지 수
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/html/apply/class_list_care";
    }


    // 운동 페이지 - default 축구
    @GetMapping("/classsport")
    public String classSport(@RequestParam(value = "category", defaultValue = "축구") String category,
                             @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                             Model model) {

        getRole(model);

        // 페이징 처리를 위한 코드
        int count = classListService.classCount(category);
        int totalPages = (int) Math.ceil((double) count / pageSize);

        List<ClassListDTO> classListDTO = classListService.findAllClass(category, pageNo, pageSize);

        int pageGroupSize = 3;
        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        model.addAttribute("count", count);
        model.addAttribute("category", category);
        model.addAttribute("classLists", classListDTO);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);

        // 4. 시작 페이지 수 5. 마지막 페이지 수
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/html/apply/class_list_sport";
    }

    // 예능 페이지 - default 그리기
    @GetMapping("/classentertainment")
    public String classEntertainment(@RequestParam(value = "category", defaultValue = "그리기") String category,
                                     @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                                     @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                     Model model) {

        getRole(model);

        // 페이징 처리를 위한 코드
        int count = classListService.classCount(category);
        int totalPages = (int) Math.ceil((double) count / pageSize);

        List<ClassListDTO> classListDTO = classListService.findAllClass(category, pageNo, pageSize);

        int pageGroupSize = 3;
        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        model.addAttribute("count", count);
        model.addAttribute("category", category);
        model.addAttribute("classLists", classListDTO);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);

        // 4. 시작 페이지 수 5. 마지막 페이지 수
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/html/apply/class_list_entertainment";
    }

    // 공부 페이지 - default 초등국어
    @GetMapping("/classstudy")
    public String classStudy(@RequestParam(value = "category", defaultValue = "초등국어") String category,
                             @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                             Model model) {

        getRole(model);

        // 페이징 처리를 위한 코드
        int count = classListService.classCount(category);
        int totalPages = (int) Math.ceil((double) count / pageSize);

        List<ClassListDTO> classListDTO = classListService.findAllClass(category, pageNo, pageSize);

        int pageGroupSize = 3;
        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        model.addAttribute("count", count);
        model.addAttribute("category", category);
        model.addAttribute("classLists", classListDTO);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);

        // 4. 시작 페이지 수 5. 마지막 페이지 수
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/html/apply/class_list_study";
    }

    // 수업 상세보기 페이지
    @GetMapping("/detail")
    public String classDetail(@RequestParam("classNumber") Long classNumber,
                              @RequestParam("proNumber") Long proNumber,
                              Model model) {

        log.info("수업 pk : " + classNumber);
        log.info("전문가 pk : " + proNumber);

        getRole(model);

        // 특정 수업에 대한 상세정보
        ClassDetailDTO class_info = classDetailService.findClassDetail(proNumber, classNumber);

        // 특정 수업에 대한 전체리뷰 조회
        List<ReviewOneListDTO> reviews = classReviewService.findOneReviewList(classNumber);

        // 특정 수업에 대한 모든 예약날짜 및 시간정보
        List<ReservationInfoDTO> reservation_infos = classDetailService.findReservation(classNumber);

        model.addAttribute("class_info", class_info);
        model.addAttribute("reservation_infos", reservation_infos);
        model.addAttribute("reviews", reviews);

        return "/html/parent/studyDetail";
    }

}
