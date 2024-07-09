package com.example.idollbom.controller.apply;

import com.example.idollbom.domain.dto.applydto.ClassDetailDTO;
import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import com.example.idollbom.service.applyservice.ClassDetailService;
import com.example.idollbom.service.applyservice.ClassListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/class")
@RequiredArgsConstructor
@Slf4j
public class ClassListController {

    private final ClassListService classListService;
    private final ClassDetailService classDetailService;

    // 돌봄 페이지
    @GetMapping("/classcare")
    public String classCare(Model model) {
        List<ClassListDTO> classListDTO = classListService.findAllClass();
        int count = classListService.classCount();

        model.addAttribute("count", count);
        model.addAttribute("classLists", classListDTO);

        return "/html/apply/class_list_care";
    }

    // 수업 상세보기
//    @GetMapping("/detail/{proNumber}")
//    public String detail(@PathVariable("proNumber") Long proNumber, Model model) {

//        ClassDetailDTO class_info = classDetailService.classDetail(proNumber, classNumber);
//        model.addAttribute("class_info", class_info);

//        return "/html/parent/studyDetail";
//    }



}
