package com.example.idollbom.domain.vo;

import lombok.*;

import java.util.Date;
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class askVO{
    private Long questionNumber;
    private String questionTitle;
    private String questionContent;
    private Date questionRegisterDate;
    private String questionReadingCheck;
    private String  questionStatus;
    private Long parentNumber;
}
