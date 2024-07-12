package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;

import java.time.LocalDate;

// 리뷰 전체 목록을 뿌려줄 때 사용하는 DTO
@Data
public class ReviewOneListDTO {

    private Long reviewNumber;
    private String reviewContent;
    private Long reviewEvaluationPoint;
    private LocalDate reviewRegisterDate;
    private LocalDate reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;
}
