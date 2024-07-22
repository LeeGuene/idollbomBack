package com.example.idollbom.controller.board;

import com.example.idollbom.domain.dto.boarddto.CommunityDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import com.example.idollbom.service.boardservice.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/parentcommunity")
@RequiredArgsConstructor
public class ParentcommunityController {

    private final CommunityService communityService;

    // 게시글 목록 띄어주는 컨트롤러
    @GetMapping()
    public String community(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                            Model model) {

        int totalCommunity = communityService.getCommunityListCount();
        int totalPages = (int) Math.ceil((double)totalCommunity/pageSize);

        List<CommunityListDTO> community = communityService.getCommunityList(pageNo, pageSize);
        System.out.println("=============" + community);

        int pageGroupSize = 5;
        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        model.addAttribute("count", totalCommunity);
        model.addAttribute("communities", community);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "html/board/parent/community_parent";
    }

    // 게시글 작성폼 컨트롤러
    @GetMapping("/write")
    public String write(Model model){
        model.addAttribute("community", new CommunityDTO());
        return "/html/board/parent/freeBoardForm_parent";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute("community") CommunityDTO community,
                        @RequestParam("parentFiles") List<MultipartFile> files){
        System.out.println("====================" + community);
        communityService.saveCommunity(community, files);
        return "redirect:/parentcommunity";
    }

}

