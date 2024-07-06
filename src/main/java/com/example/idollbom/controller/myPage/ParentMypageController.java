package com.example.idollbom.controller.myPage;

import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import com.example.idollbom.domain.vo.myPagevo.parentvo.kidVO;
import com.example.idollbom.service.myPageservice.parentservice.kidsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/ParentMyPage")
@RequiredArgsConstructor
@Slf4j
public class ParentMypageController {

    private final kidsService kidsService;

//  kid 페이지로 이동
    @GetMapping("/kids")
    public String getKids(Model model){
        List<kidVO> kids = kidsService.selectKidsList();
        model.addAttribute("kid", new kidDTO());
        model.addAttribute("kids", kids);
        return "html/myPage/parent/myKids";
    }

//  아이등록
    @PostMapping("/insertKids")
    public String insertKids(@ModelAttribute kidDTO kid){
        log.info("HTML에서 넘어온 데이터: " + kid);

        LocalDate birthday = LocalDate.parse(kid.getChildAge());

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthday, currentDate);
        int age = period.getYears();
        kid.setChildAge(String.valueOf(age));
        kidsService.insertKids(kid);

        return "redirect:/ParentMyPage/kids";
    }



}
