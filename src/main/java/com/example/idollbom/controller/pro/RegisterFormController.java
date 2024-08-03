package com.example.idollbom.controller.pro;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.prodto.ClassDTO;
import com.example.idollbom.domain.dto.prodto.ReservationDateDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.service.loginservice.ProService;
import com.example.idollbom.service.proService.RegisterFormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

@Controller
@RequestMapping("/pro")
@RequiredArgsConstructor
@Slf4j
public class RegisterFormController {

    private final RegisterFormService registerFormService;
    private final ProService proService;

    // 수업등록하는 화면으로 이동 컨트롤러
    @GetMapping("/register")
    public String registerFromController(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {

            CustomUserDTO pro = ((CustomUserDTO) authentication.getPrincipal());
            String proId = pro.getEmail();

            ProVO pro_info = proService.selectPro(proId);

            String role = pro_info.getRole();
            System.out.println(role);

            model.addAttribute("role", role);
        }

        return "/html/pro/registerForm";
    }

    // 수업 등록을 눌렀을 때
    @PostMapping("/register")
    public String registerFromController(ClassDTO classDTO,
                                         @RequestParam("care") String care,
                                         @RequestParam("education") String education,
                                         @RequestParam("sport") String sport,
                                         @RequestParam("entertainment") String entertainment,
                                         @RequestParam("imageFileUrl") MultipartFile imageFileUrl,
                                         ReservationDateDTO reservationDateDTO,
                                         @RequestParam("resDate") String resDate,
//                                         ReservationTimeDTO reservationTimeDTO,
                                         @RequestParam("selectedTimes") String selectedTimes) {

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

//        // html에서 받아온 날짜를 localDate 형식으로 반환
        LocalDate localDate = LocalDate.parse(resDate);
        reservationDateDTO.setReservationDate(localDate);

        // 쉼표로 구분된 문자열을 리스트로 변환
        List<String> timesList = Arrays.asList(selectedTimes.split("\\s*,\\s*"));
        // 중복 제거를 위해 Set으로 변환 후 다시 리스트로 변환
        List<String> uniqueTimesList = new ArrayList<>(new LinkedHashSet<>(timesList));
        System.out.println("Selected times list without duplicates: " + uniqueTimesList);


        // 현재 reservationNumber를 받아옴
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");

        for (String time : uniqueTimesList) {
            LocalTime localTime = LocalTime.of(Integer.parseInt(time), 0); // 시간을 LocalTime으로 변환 (분은 0으로 고정)
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            localDateTimes.add(localDateTime);
        }

        registerFormService.registerClass(classDTO, reservationDateDTO, imageFileUrl, localDateTimes);

        // 전문가 마이페이지 수업 목록으로 옮기기
        return "redirect:/proMyPage/proClass";
    }
}
