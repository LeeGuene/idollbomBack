package com.example.idollbom.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
public class AnswerVO {

    private Long answerNumber;
    private String answerContent;
    private Long questionNumber;

    @Builder
    public AnswerVO(Long answerNumber, String answerContent, Long questionNumber) {
        this.answerNumber = answerNumber;
        this.answerContent = answerContent;
        this.questionNumber = questionNumber;
    }



}
