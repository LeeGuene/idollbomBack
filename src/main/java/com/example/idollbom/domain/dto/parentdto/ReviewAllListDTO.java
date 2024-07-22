package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReviewAllListDTO {

    private Long reviewNumber;
    private String reviewContent;
    private Long reviewEvaluationPoint;
    private LocalDateTime reviewRegisterDate;
    private LocalDateTime reviewUpdateDate;
    private Long classNumber;
    private String proNumber;

}
