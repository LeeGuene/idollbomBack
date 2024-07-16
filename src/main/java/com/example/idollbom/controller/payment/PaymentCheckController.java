package com.example.idollbom.controller.payment;

import com.example.idollbom.domain.dto.applydto.ClassDetailDTO;
import com.example.idollbom.domain.vo.kidVO;
import com.example.idollbom.service.myPageservice.parentservice.kidsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    // 수업 상세보길글 가져오기 위한 의존성 주입
    
    // 결제확인창 컨틀롤러
    // 이때 로그인한 부모의 pk와 수업pk를 가져와서 데이터를 뿌려줘야한다.
    @GetMapping("/{reservationDate}/{reservationTime}")
    public String paymentCheck(@PathVariable("reservationDate") String reservationDate,
                               @PathVariable("reservationTime") String reservationTime,
                               @RequestParam("classNumber") Long classNumber,
                               @RequestParam("class_info") ClassDetailDTO class_info,
                               Model model) {

        // 로그인한 부모에 대한 아이 이름 가져오기
        List<kidVO> kids = kidsService.selectKidsList();
        System.out.println("============" + kids);
        model.addAttribute("kids", kids);

        return "/html/payment/paymentCheck";
    }

    // 결제하기 버튼을 눌렀을 때

    // 뒤로가기 버튼을 눌렀을 때

}
