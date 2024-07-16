package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

@Data
public class ProReviewListDTO {

    private Long reviewNumber;
    private String reviewContent;
    private String reviewRegisterDate;
    private String reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;

}
