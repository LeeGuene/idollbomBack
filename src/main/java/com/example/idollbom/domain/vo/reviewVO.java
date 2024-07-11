package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.parentdto.ReviewDTO;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@Builder
public class reviewVO {
    private Long reviewNumber;                      // pk
    private String reviewContent;                   // 리뷰 내용
    private Long reviewEvaluationPoint;             // 별점
    private LocalDate reviewRegisterDate;           // 리뷰 등록일
    private LocalDate reviewUpdateDate;             // 리뷰 수정일
    private Long parentNumber;                      // fk (부모 번호)
    private Long classNumber;                       // fk (수업 번호)

    @Builder
    public reviewVO(Long reviewNumber, String reviewContent, Long reviewEvaluationPoint, LocalDate reviewRegisterDate, LocalDate reviewUpdateDate, Long parentNumber, Long classNumber) {
        this.reviewNumber = reviewNumber;
        this.reviewContent = reviewContent;
        this.reviewEvaluationPoint = reviewEvaluationPoint;
        this.reviewRegisterDate = reviewRegisterDate;
        this.reviewUpdateDate = reviewUpdateDate;
        this.parentNumber = parentNumber;
        this.classNumber = classNumber;
    }

    public static reviewVO toEntity(ReviewDTO dto){
        return reviewVO.builder()
                .reviewNumber(dto.getReviewNumber())
                .reviewContent(dto.getReviewContent())
                .reviewEvaluationPoint(dto.getReviewEvaluationPoint())
                .reviewRegisterDate(dto.getReviewRegisterDate())
                .reviewUpdateDate(dto.getReviewUpdateDate())
                .parentNumber(dto.getParentNumber())
                .classNumber(dto.getClassNumber())
                .build();
    }

}
