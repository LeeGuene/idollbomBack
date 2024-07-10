package com.example.idollbom.controller.apply;

import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import com.example.idollbom.service.applyservice.ClassListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    // 페이지 전부 페이징 처리 구현하기
    // 돌봄 페이지, default는 등하원으로
    @GetMapping("/classcare")
    public String classCare(@RequestParam(value = "category", defaultValue = "등/하원") String category,
                            @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                            Model model) {

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

        return "/html/apply/class_list_care";
    }


    // 운동 페이지 - default 축구
    @GetMapping("/classsport")
    public String classSport(@RequestParam(value = "category", defaultValue = "축구") String category,
                             @RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                             Model model) {
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

    // 검색 기능 구현
    @GetMapping("/search")
    public String classSearch(@RequestParam(name = "searchWord") String searchWord,
                              @RequestParam(name = "searchType") String searchType,
                              @RequestParam(value = "category", defaultValue = "등/하원") String category,
                              Model model) {

        List<ClassListDTO> classListDTO = classListService.searchClassList(searchWord, searchType, category);
        int count = classListService.countClasses(category,searchType, searchWord);

        model.addAttribute("count", count);
        model.addAttribute("classLists", classListDTO);
        return "/html/apply/class_list_care";
    }

    // 수업 상세보기 페이지
    // 수업 상세보기
//    @GetMapping("/detail")
//    public String detail(@RequestParam("classNumber") Long classNumber,
//                         @RequestParam("proNumber") Long proNumber,
//                         ,Model model) {

//        ClassDetailDTO class_info = classDetailService.classDetail(proNumber, classNumber);
//        model.addAttribute("class_info", class_info);

//        return "/html/parent/studyDetail";
//    }
}
