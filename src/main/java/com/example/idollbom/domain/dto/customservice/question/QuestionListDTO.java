package com.example.idollbom.domain.dto.customservice.question;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class QuestionListDTO {

    private String parentName;                  // 작성자 이름
    private Long questionNumber;                // 문의하기 pk
    private String questionTitle;               // 문의하기 제목
    private String questionContent;             // 문의하기 내용
    private LocalDate questionRegisterDate;     // 문의하기 등록일
    private String questionReadingCheck;        // 문의하기 열람가능 여부 (공개, 비공개)
    private String questionStatus;              // 문의하기 상태 (완료, 미완료)
    private Long answerNumber;                  // 문의답변 pk(fk)
    private String answerContent;               // 문의 답변내용

}
