package com.example.idollbom.controller.parent;

import com.example.idollbom.domain.dto.parentdto.ReviewOneListDTO;
import com.example.idollbom.service.applyservice.ClassReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ClassReviewService classReviewService;

    // 수업 상세보기 페이지애서 특정 수업에 대한 모든 리뷰를 조회
    @GetMapping("/{classNumber}")
    public ResponseEntity<?> getReview(@PathVariable Long classNumber) {
        List<ReviewOneListDTO> reviews = classReviewService.findOneReviewList(classNumber);
        return ResponseEntity.ok(reviews);

    }
}
