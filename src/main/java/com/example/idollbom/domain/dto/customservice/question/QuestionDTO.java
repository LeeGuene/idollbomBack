package com.example.idollbom.domain.dto.customservice.question;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class QuestionDTO {

    private Long questionNumber;
    private String questionTitle;
    private String questionContent;
    private String questionReadingCheck;
    private Long parentNumber;

}
