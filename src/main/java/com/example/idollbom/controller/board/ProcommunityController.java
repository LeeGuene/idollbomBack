package com.example.idollbom.controller.board;

import com.example.idollbom.domain.dto.boarddto.ProCommunityDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommunityDetailDTO;
import com.example.idollbom.domain.dto.boarddto.ProFileDTO;
import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.mapper.loginmapper.ProMapper;
import com.example.idollbom.service.boardservice.ProCommunityService;
import com.example.idollbom.service.boardservice.ProFileService;
import com.example.idollbom.service.boardservice.ProReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/procommunity")
@RequiredArgsConstructor
public class ProcommunityController {

    private final ProCommunityService proCommunityService;
    private final ProFileService proFileService;
    private final ProReportService proReportService;
    private final ProMapper proMapper;

    // 전문가 페이지이동 컨트롤러
    @GetMapping()
    public String proCommunity(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {
            CustomUserDTO p = ((CustomUserDTO) authentication.getPrincipal());

            String userRole = p.getRole();
            String proId = p.getEmail();

            System.out.println(userRole);
            model.addAttribute("userRole", userRole);
            ProVO pro = proMapper.selectPro(proId);
            model.addAttribute("proNumber", pro.getProNumber());
        }

        return "/html/board/pro/community_pro";
    }

    // 현재 pk를 가지고 오는 메소드
    public Long findProPK(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDTO p = ((CustomUserDTO) authentication.getPrincipal());
        String proName = p.getUsername();

        ProVO pro_info = proMapper.selectPro(proName);

        return pro_info.getProNumber();
    }

    // 게시글 작성폼 이동
    @GetMapping("/proWrite")
    public String proWrite(Model model) {
        model.addAttribute("pro", new ProCommunityDTO());
        return "/html/board/pro/freeBoardForm_pro";
    }

    // 게시글 수정 및 작성폼
    @PostMapping("proWrite")
    public String proWrite(@ModelAttribute ProCommunityDTO pro,
                           @RequestParam("proFiles") List<MultipartFile> proFiles,
                           @RequestParam(value = "proNumber", required = false) Long proNumber) {

        // 현재 로그인한 pk 가지고 오기
        Long proId = findProPK();
        Long proPostNumber = pro.getProPostNumber();

        if(proPostNumber !=null && proId.equals(proNumber)){
            proCommunityService.updateProCommunity(pro, proFiles);
            return "redirect:/procommunity/detail/" + proPostNumber;
        }

        proCommunityService.saveProCommunity(pro, proFiles, proId);
        return "redirect:/procommunity";
    }

    // 게시글 상세보기 페이지
    @GetMapping("/detail/{proPostNumber}")
    public String ProDetail(@PathVariable("proPostNumber") Long proPostNumber, Model model) {

        Long proId = findProPK();

        ProCommunityDetailDTO proDetail = proCommunityService.selectProCommunityDetail(proPostNumber, proId);
        List<ProFileDTO> files = proFileService.selectProFileList(proPostNumber);

        model.addAttribute("pro", proDetail);
        model.addAttribute("files", files);
        model.addAttribute("proId", proId);

        return "/html/board/pro/freeBoardDetail_pro";
    }

    // 게시글 삭제
    @PostMapping("/delete/{proPostNumber}/{proNumber}")
    public String ProDelete(@PathVariable("proPostNumber") Long proPostNumber,
                            @PathVariable("proNumber") Long proNumber){

        Long proId = findProPK();

        if(proId.equals(proNumber)){
            proCommunityService.deleteProCommunity(proPostNumber);
        }
        return "redirect:/procommunity";
    }

    // 게시글 수정하기
    @GetMapping("edit/{proPostNumber}/{proNumber}")
    public String ProEdit(@PathVariable("proPostNumber") Long proPostNumber,
                          @PathVariable("proNumber") Long proNumber,
                          Model model) {
        Long proId = findProPK();

        if(proId.equals(proNumber)){
            model.addAttribute("pro", proCommunityService.selectProCommunityDetail(proPostNumber, proNumber));
            return "/html/board/pro/freeBoardForm_pro";
        }
        return "redirect:/procommunity";
    }

    // 전문가 신고하기
    @PostMapping("/proReport")
    public String proReport(@RequestParam("proPostNumber") Long proPostNumber,
                            @RequestParam("reportType") String reportType,
                            @RequestParam("reportForm") String reportForm) {

        proReportService.saveProReport(proPostNumber, reportType, reportForm);
        return "redirect:/procommunity";
    }
}
