package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

// 강사 프로필 상세보기 (리뷰 포함) 페이지에서 뿌려줄 데이터 DTO
@Data
public class ProReviewListDTO {

    private String parentName;
    private Long reviewNumber;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;
    private String className;

}
