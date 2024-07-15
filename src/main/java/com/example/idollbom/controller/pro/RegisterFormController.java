package com.example.idollbom.controller.pro;

import com.example.idollbom.domain.dto.prodto.ClassDTO;
import com.example.idollbom.domain.dto.prodto.ReservationDateDTO;
import com.example.idollbom.domain.dto.prodto.ReservationTimeDTO;
import com.example.idollbom.domain.vo.classVO;
import com.example.idollbom.service.proService.RegisterFormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/pro")
@RequiredArgsConstructor
@Slf4j
public class RegisterFormController {

    private final RegisterFormService registerFormService;

    // 수업등록하는 화면으로 이동 컨트롤러
    @GetMapping("/register")
    public String registerFromController() {
        return "/html/pro/registerForm";
    }

    // 수업 등록을 눌렀을 때
    @PostMapping("/register")
    public String registerFromController(ClassDTO classDTO,
                                         @RequestParam("care") String care,
                                         @RequestParam("education") String education,
                                         @RequestParam("sport") String sport,
                                         @RequestParam("entertainment") String entertainment,
                                         ReservationDateDTO reservationDateDTO,
                                         @RequestParam("resDate") String resDate,
                                         ReservationTimeDTO reservationTimeDTO,
                                         @RequestParam("resTime") String resTime) {

        // 대카에 대한 소카 저장
        switch (classDTO.getClassCategoryBig()) {
            case "돌봄":
                classDTO.setClassCategorySmall(care);
                break;
            case "교육":
                classDTO.setClassCategorySmall(education);
                break;
            case "운동":
                classDTO.setClassCategorySmall(sport);
                break;
            case "예능":
                classDTO.setClassCategorySmall(entertainment);
                break;
            default:
                break;
        }

        // html에서 받아온 날짜를 localDate 형식으로 반환
        LocalDate localDate = LocalDate.parse(resDate);
        reservationDateDTO.setReservationDate(localDate);

        // 입력 받은 시간을 LocalTime으로 변환
        LocalTime localTime = LocalTime.of(Integer.parseInt(resTime), 0); // 분은 0으로 고정
        // 입력한 날짜와 LocalDateTime으로 조합
        LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);
        reservationTimeDTO.setReservationTime(dateTime);

        registerFormService.registerClass(classDTO, reservationDateDTO, reservationTimeDTO);

        // 이건 어디로 가야 좋을지..
        return "redirect:/pro/register";
    }
}
