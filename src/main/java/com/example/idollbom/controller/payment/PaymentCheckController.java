package com.example.idollbom.controller.payment;

import com.example.idollbom.domain.dto.applydto.ClassDetailDTO;
import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.parentdto.ReservationInfoDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.domain.vo.kidVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.applyservice.ClassDetailService;
import com.example.idollbom.service.myPageservice.parentservice.kidsService;
import com.example.idollbom.service.myPageservice.parentservice.noteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/paymentcheck")
@RequiredArgsConstructor
@Slf4j
public class PaymentCheckController {

    // 아이의 이름을 가져오기 위한 의존성 주입
    private final kidsService kidsService;

    // 수업 상세보기 가져오기 위한 의존성 주입
    private final ClassDetailService classDetailService;
    private final ParentMapper parentMapper;
    
    // 쪽지함 목록개수를 가져오기 위한 의존성 주입
    private final noteService noteService;

    // 결제확인창 컨틀롤러
    // 이때 로그인한 부모의 pk와 수업pk를 가져와서 데이터를 뿌려줘야한다.
    @GetMapping("/{classNumber}")
    public String paymentCheck(@RequestParam("reservationDateNumber") Long reservationDateNumber,
                               @RequestParam("reservationTimeNumber") Long reservationTimeNumber,
                               @RequestParam("proNumber") Long proNumber,
                               @PathVariable("classNumber") Long classNumber,
                               Model model) {

        // 현재 로그인한 부모 pk 전달
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDTO p = ((CustomUserDTO) authentication.getPrincipal());
        String parentName = p.getUsername();

        ParentVO parent_info = parentMapper.selectOne(parentName);
        Long parentId = parent_info.getParentNumber();
        
        // 쪽지 목록개수 조회
        int count = noteService.countParentNoteList(parentId);
        model.addAttribute("count", count);
        model.addAttribute("role", parent_info.getRole());

        model.addAttribute("parent_info", parent_info);
        model.addAttribute("parentId", parentId);

        System.out.println("예약날짜 pk : " + reservationDateNumber);
        System.out.println("주소로 받아온 classNumber : " + classNumber);
        System.out.println("전문가 pk : " + proNumber);

        // 나중에 전문가 정보를 받아와야하는 코드 추가 지금은 33이 디폴트
        ClassDetailDTO proInfo = classDetailService.findClassDetail(proNumber, classNumber);
        System.out.println("================" + proInfo);
        model.addAttribute("proInfo", proInfo);

        // 선택한 예약날짜와 시간 가져오기
        ReservationInfoDTO reservationInfo = classDetailService.findReservationInfo(reservationDateNumber, reservationTimeNumber);
        System.out.println("================" + reservationInfo);
        model.addAttribute("reservationInfo", reservationInfo);

        // 로그인한 부모에 대한 아이 이름 가져오기
        List<kidVO> kids = kidsService.selectKidsList();
        System.out.println("============" + kids);
        model.addAttribute("kids", kids);

        return "/html/payment/paymentcheck";
    }
}
