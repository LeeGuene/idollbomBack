package com.example.idollbom.controller.apply;

import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import com.example.idollbom.service.applyservice.ClassListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/class")
@RequiredArgsConstructor
@Slf4j
public class ClassListController {

    private final ClassListService classListService;

    // 돌봄 페이지
    @GetMapping("/classcare")
    public String classCare(Model model) {
        List<ClassListDTO> classListDTO = classListService.findAllClass();
        int count = classListService.classCount();

        model.addAttribute("count", count);
        model.addAttribute("classLists", classListDTO);
        return "/html/apply/class_list_care";
    }
}
