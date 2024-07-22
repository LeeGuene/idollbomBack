package com.example.idollbom.controller.myPage;
import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import com.example.idollbom.domain.dto.myPagedto.parentdto.mailDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.domain.vo.kidVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.loginservice.ParentDetailService;
import com.example.idollbom.service.myPageservice.parentservice.classSaveService;
import com.example.idollbom.service.myPageservice.parentservice.kidsService;
import com.example.idollbom.service.myPageservice.parentservice.noteService;
import com.example.idollbom.service.myPageservice.parentservice.parentInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/ParentMyPageRest")
@RequiredArgsConstructor
@Slf4j
public class parentMyPageRestController {

    private final kidsService kidsService;
    private final noteService noteService;
    private final classSaveService classSaveService;
    private final ParentMapper parentMapper;

//  아이정보 넘기기
    @GetMapping("/kidById")
    public kidVO selectKidById(@RequestParam(value = "childNumber", required = true) Long childNumber){

       return kidsService.selectKidById(childNumber);
    }

    //  아이 update
    @PutMapping("/updateKids/{childNumber}")
    public ResponseEntity<?> updateKid(@PathVariable("childNumber") Long childNumber, @RequestBody kidDTO updatedKid) {
//      날짜 -> 나이로 변환
        log.info("넘어온거" + updatedKid);
        log.info("이름"+ updatedKid.getChildName());
        LocalDate birthday = LocalDate.parse(updatedKid.getChildAge());
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthday, currentDate);
        int age = period.getYears();
        updatedKid.setChildAge(String.valueOf(age));

        kidsService.updateByKidId(updatedKid);

        // 클라이언트에게 추가 정보를 반환하지 않음
        return ResponseEntity.noContent().build();
    }

//  mail 정보 넘겨주기
    @GetMapping("/mailDetail")
    public mailDTO selectMailId(@RequestParam(value = "mailId", required = true) Long mailId){
        return noteService.selectOneMail(mailId);
    }

    // 신청하기 페이지의 수업 찜 목록 버튼 클릭시 이동되는 컨트롤러
    @PostMapping("/insertSaveClass/{classNumber}")
    public ResponseEntity<?> insertSaveClass(@PathVariable(value="classNumber") String classNumber){

        log.info("View에서 받아온 수업 pk : " + classNumber);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

        Long long_classNumber = Long.parseLong(classNumber);

        ParentVO parent_info = parentMapper.selectOne(currentUserName);
        classSaveService.saveClass(long_classNumber, parent_info.getParentNumber());

        return ResponseEntity.ok("Data processed successfully");
    }

}

































