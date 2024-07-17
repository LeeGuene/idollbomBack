package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ReviewDTO {
    private Long reviewNumber;
    private String reviewContent;
    private Long reviewEvaluationPoint;
    private LocalDate reviewRegisterDate;
    private LocalDate reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;
    private Long reviewCompleted;
}
