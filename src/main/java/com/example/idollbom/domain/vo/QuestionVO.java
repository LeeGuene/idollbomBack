package com.example.idollbom.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@ToString
@NoArgsConstructor
public class QuestionVO {

    private Long questionNumber;
    private String questionTitle;
    private String questionContent;
    private LocalDateTime questionRegisterDate;
    private String questionReadingCheck;
    private String questionStatus;
    private Long parentNumber;

    @Builder
    public QuestionVO(Long questionNumber, String questionTitle, String questionContent, LocalDateTime questionRegisterDate, String questionReadingCheck, String questionStatus, Long parentNumber){
        this.questionNumber = questionNumber;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRegisterDate = questionRegisterDate;
        this.questionReadingCheck = questionReadingCheck;
        this.questionStatus = questionStatus;
        this.parentNumber = parentNumber;
    }

}
