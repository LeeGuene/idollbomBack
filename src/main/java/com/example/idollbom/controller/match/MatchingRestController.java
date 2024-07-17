package com.example.idollbom.controller.match;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import com.example.idollbom.service.matchservice.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchingRestController {

    private final MatchingService matchingService;

    // 검색버튼을 눌렀을 때 뿌려주는 전문가 매칭 정보
    // 리턴은 데이터를 뿌려주면 된다.
    @PostMapping("/submit")
    public ResponseEntity<?> submitData(@RequestBody Map<String, String> requestData) {
        String category = requestData.get("category");
        String categoryData = requestData.get("categoryData");
        String selectedDate = requestData.get("selectedDate");
        String selectedTime = requestData.get("selectedTime");

        System.out.println(category);
        System.out.println(categoryData);
        System.out.println(selectedDate);
        System.out.println(selectedTime);

        return ResponseEntity.ok(matchingService.matchClass(category, categoryData, selectedDate, selectedTime));
    }
}
