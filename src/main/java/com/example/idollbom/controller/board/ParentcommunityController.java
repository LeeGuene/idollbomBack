package com.example.idollbom.controller.board;

import com.example.idollbom.domain.dto.boarddto.CommunityDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityDetailDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.service.boardservice.CommunityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/parentcommunity")
@RequiredArgsConstructor
public class ParentcommunityController {

    private final CommunityService communityService;

    // 게시글 목록 띄어주는 컨트롤러
    @GetMapping()
    public String community(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
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

    // 현재 pk를 가지고 오는 메소드
    public Long findParentPK(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ParentVO p = ((ParentVO) authentication.getPrincipal());
        return p.getParentNumber();
    }

    // 게시글 작성 및 수정 (같은 폼에서 할 거기 때문에)
    @PostMapping("/write")
    public String write(@ModelAttribute("community") CommunityDTO community,
                        @RequestParam("parentFiles") List<MultipartFile> files){

        // 현재 로그인한 pk가지고옴
        Long parentNumber = findParentPK();
        int parentPostNumber = community.getParentPostNumber();


        // 현재 parentPostNumber 를 가지고 있다면 수정폼
        // 첨부파일은 아직 하기 전
        if(parentPostNumber != 0 && parentNumber.equals(community.getParentNumber())){
            communityService.updateCommunity(community);
            return "redirect:/parentcommunity/detail/" + parentPostNumber;
        }

        communityService.saveCommunity(community, files, parentNumber);
        return "redirect:/parentcommunity";
    }

    // 게시글 상세보기
    @GetMapping("/detail/{parentPostNumber}")
    public String detail(@PathVariable("parentPostNumber") Long parentPostNumber, Model model){

        CommunityDetailDTO community = communityService.selectCommunityDetail(parentPostNumber);
        model.addAttribute("community", community);

        return "/html/board/parent/freeBoardDetail_parent";
    }

    // 게시글 삭제하기
    @PostMapping("/delete/{parentPostNumber}/{parentNumber}")
    public String delete(@PathVariable("parentPostNumber") Long parentPostNumber,
                         @PathVariable("parentNumber") Long parentNumber){
        System.out.println(parentNumber);
        Long parentId = findParentPK();

        // 현재 로그인한 pk와 작성한 pk가 같다면 삭제 실행
        if(parentId.equals(parentNumber)){
            communityService.deleteCommunity(parentPostNumber);
        }
        return "redirect:/parentcommunity";
    }

    // 게시글 수정하기
    @GetMapping("/edit/{parentPostNumber}/{parentNumber}")
    public String edit(@PathVariable("parentPostNumber") Long parentPostNumber,
                       @PathVariable("parentNumber") Long parentNumber,
                       Model model){

        Long parentId = findParentPK();

        // 현재 로그인한 pk와 작성한 pk가 같다면 수정 실행
        if(parentId.equals(parentNumber)){
            model.addAttribute("community", communityService.selectCommunityDetail(parentPostNumber));
            return "/html/board/parent/freeBoardForm_parent";
        }
        // 현재 로그인한 사람이 아니라면
        return "redirect:/parentcommunity";
    }
}

