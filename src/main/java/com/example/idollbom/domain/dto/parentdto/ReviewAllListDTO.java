package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewAllListDTO {

    private Long reviewNumber;
    private String reviewContent;
    private Long reviewEvaluationPoint;
    private LocalDate reviewRegisterDate;
    private LocalDate reviewUpdateDate;
    private Long classNumber;
    private String proNumber;

}
