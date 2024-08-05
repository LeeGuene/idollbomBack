package com.example.idollbom.controller.main;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.parentdto.ProListDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.myPageservice.parentservice.noteService;
import com.example.idollbom.service.proService.ProDetailService;
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
@RequestMapping("/parentmain")
@RequiredArgsConstructor
@Slf4j
public class ParentMainController {

    private final ProDetailService proDetailService;
    private final ParentMapper parentMapper;
    private final noteService noteService;

    // 부모 role, parentNumber, 쪽지 목록 개수를 받아오는 메서드
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
        }
    }

    //   부모 메인페이지로 이동
    @GetMapping
    public String parentmain(Model model){

        // 부모 role, parentNumber, 쪽지 목록 개수를 받아와서 view에 전달
        getRole(model); 

        return "/html/main/index_parents";
    }

    // 전문가 정보 리스트 페이지로 이동
    @GetMapping("/prolist")
    public String goProList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
                            Model model){

        // log.info("View에서 받아온 정보 : ");
        // log.info("pageNo" + pageNo);
        // log.info("pageSize" + pageSize);

        // 부모 role, parentNumber, 쪽지 목록 개수를 받아와서 view에 전달
        getRole(model);

        // 페이징 처리
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
