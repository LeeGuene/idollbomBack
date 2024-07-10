package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;

import java.util.Date;

// 리뷰 전체 목록을 뿌려줄 때 사용하는 DTO
@Data
public class ReviewListDTO {

    private Long reviewNumber;
    private String reviewContent;
    private Long reviewEvaluationPoint;
    private Date reviewRegisterDate;
    private Date reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;
    private String name;                    // 리뷰 작성자 이름

}
