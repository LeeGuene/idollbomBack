package com.example.idollbom.controller.myPage;

import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import com.example.idollbom.service.myPageservice.parentservice.kidsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ParentMyPage")
@RequiredArgsConstructor
@Slf4j
public class ParentMypageController {

    private final kidsService kidsService;
    @GetMapping("/kids")
    public String getKids(){
        return "/html/mypage/parent/myKids";
    }

    @PostMapping
    public String insertKids(@RequestBody kidDTO kidDTO){
        kidsService.insertKids(kidDTO);
        return "redirect:/ParentMyPage/kids";
    }



}
