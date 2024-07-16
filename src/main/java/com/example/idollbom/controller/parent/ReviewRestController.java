package com.example.idollbom.controller.parent;

import com.example.idollbom.domain.dto.parentdto.ReviewDTO;
import com.example.idollbom.domain.dto.parentdto.ReviewOneListDTO;
import com.example.idollbom.service.applyservice.ClassReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ClassReviewService classReviewService;

    // 특정 수업에 대한 전체 리뷰 조회
    @GetMapping("/{classNumber}")
    public ResponseEntity<?> getReview(@PathVariable("classNumber") Long classNumber) {
        List<ReviewDTO> reviews = classReviewService.findReviews(classNumber);
        return ResponseEntity.ok(reviews);
    }

    // 특정 전문가에 대한 리뷰 추가
    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody ReviewDTO review){
        // 수업 상세보기 페이지에서 받아온 사용자 데이터로 쿼리문 실행
        classReviewService.saveReviews(review);
        return ResponseEntity.ok().build();
    }

    // 특정 수업에 대한 리뷰 삭제
    @DeleteMapping("/{classNumber}")
    public ResponseEntity<?> deleteReview(@PathVariable("classNumber") Long classNumber){
        classReviewService.deleteReviews(classNumber);
        return ResponseEntity.ok().build();
    }

    // 특정 수업에 대한 리뷰 수정
//    @PutMapping("/{classNumber}")
//    public ResponseEntity<?> updateReview(@PathVariable("classNumber") Long classNumber,
//                                          @RequestBody ReviewDTO reviewDTO){
//
//
//        return ResponseEntity.ok().build();
//    }



}
