package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewDTO {

    private Long reviewNumber;
    private String reviewContent;
    private Long reviewEvaluationPoint;
    private Date reviewRegisterDate;
    private Date reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;

}
