package com.example.idollbom.domain.vo.myPagevo.parentvo;

import lombok.*;

import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class reviewVO {
    private Long reviewNumber;
    private String reviewContent;
    private Long reviewEvaluationPoint;
    private Date reviewRegisterDate;
    private Date reviewUpdateDate;
    private Long parentNumber;
    private Long classNumber;
}
