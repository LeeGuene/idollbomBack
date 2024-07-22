package com.example.idollbom.domain.dto.prodto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// 강사 프로필 상세보기 (리뷰 포함) 페이지에서 뿌려줄 데이터 DTO
@Component
@Data
public class ProReviewListDTO {

    private String parentName;
    private Long reviewNumber;
    private String reviewContent;
    private LocalDateTime reviewRegisterDate;
    private LocalDateTime reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;
    private String className;

}
