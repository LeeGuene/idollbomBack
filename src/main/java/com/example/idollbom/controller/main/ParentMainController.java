package com.example.idollbom.controller.main;

import com.example.idollbom.domain.dto.parentdto.ProListDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.proService.ProDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/parentmain")
@RequiredArgsConstructor
@Slf4j
public class ParentMainController {

    private final ParentMapper parentMapper;
    private final ProDetailService proDetailService;

    //   부모 메인페이지로 이동
    @GetMapping
    public String parentmain(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

        ParentVO parent_info = parentMapper.selectOne(currentUserName);
        // 로그인 한 회원(부모)의 정보를 메인 페이지 이동할 때 전달
        model.addAttribute("parent_info", parent_info);

        return "/html/main/index_parents.html";
    }

    // 전문가 정보 리스트 페이지로 이동
    @GetMapping("/prolist")
    public String goProList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
                            Model model){

        log.info("View에서 받아온 정보 : ");
        log.info("pageNo" + pageNo);
        log.info("pageSize" + pageSize);

        int totalPros = proDetailService.getProCount();
        int totalPages = (int) Math.ceil((double) totalPros / pageSize);

        int pageGroupSize = 5;

        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        List<ProListDTO> pro_infos = proDetailService.findAllProList(pageNo, pageSize);

        model.addAttribute("pro_infos", pro_infos);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/html/parent/prolist";
    }

}
