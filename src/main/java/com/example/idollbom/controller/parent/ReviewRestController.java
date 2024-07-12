package com.example.idollbom.controller.parent;

import com.example.idollbom.domain.dto.parentdto.ReviewDTO;
import com.example.idollbom.service.applyservice.ClassReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ClassReviewService classReviewService;

    // 특정 전문가에 대한 리뷰 추가
    // 부모 pk, 수업 pk를 주소(경로)에 받아서 넘어온다. ( view -> controller )
    @PostMapping
    public ResponseEntity<?> addReview(@RequestParam("parentNumber") Long parentNumber,
                                       @RequestParam("classNumber") Long classNumber,
                                       @RequestBody ReviewDTO review){
        // View 에서 부모 pk, 수업 pk를 받아온 다음, 쿼리문 실행
        // 부모 pk 정보는 어디서 받아오지?? >> 로그인할 때
        review.setParentNumber(parentNumber);
        review.setClassNumber(classNumber);
        
        classReviewService.saveReview(review);

        return ResponseEntity.ok().build();
    }

    // 특정 수업에 대한 리뷰 삭제
    @DeleteMapping("/{reviewNumber}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewNumber") Long reviewNumber){
        classReviewService.deleteReview(reviewNumber);
        return ResponseEntity.ok().build();
    }
    
    // 특정 수업에 대한 리뷰 수정
    @PutMapping("/{reviewNumber}")
    public ResponseEntity<?> updateReview(@PathVariable("reviewNumber") Long reviewNumber,
                                          @RequestBody ReviewDTO reviewDTO){
        // view 단에서 DTO 안에는 reviewNumber 는 비어있는 상태임.
        // 주소로 받아온 reviewNumber로 채워준 다음, 쿼리문 실행
        reviewDTO.setReviewNumber(reviewNumber);
        classReviewService.updateReview(reviewDTO);

        return ResponseEntity.ok().build();
    }



}
