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
public class ParentCommentVO {

    private Long parentCommentNumber;
    private String parentCommentContent;
    private LocalDateTime parentCommentRegisterDate;
    private LocalDateTime parentCommentUpdateDate;
    private Long parentNumber;
    private Long parentPostNumber;

    @Builder
    public ParentCommentVO(Long parentCommentNumber, String parentCommentContent, LocalDateTime parentCommentRegisterDate, LocalDateTime parentCommentUpdateDate, Long parentNumber, Long parentPostNumber) {
        this.parentCommentNumber = parentCommentNumber;
        this.parentCommentContent = parentCommentContent;
        this.parentCommentRegisterDate = parentCommentRegisterDate;
        this.parentCommentUpdateDate = parentCommentUpdateDate;
        this.parentNumber = parentNumber;
        this.parentPostNumber = parentPostNumber;
    }

}
