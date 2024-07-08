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
public class ProCommentVO {

    private Long proCommentNumber;
    private String proCommentContent;
    private LocalDateTime proCommentRegisterDate;
    private LocalDateTime proCommentUpdateDate;
    private Long proPostNumber;
    private Long proNumber;

    @Builder
    public ProCommentVO (Long proCommentNumber, String proCommentContent, LocalDateTime proCommentRegisterDate, LocalDateTime proCommentUpdateDate, Long proPostNumber, Long proNumber) {
        this.proCommentNumber = proCommentNumber;
        this.proCommentContent = proCommentContent;
        this.proCommentRegisterDate = proCommentRegisterDate;
        this.proCommentUpdateDate = proCommentUpdateDate;
        this.proPostNumber = proPostNumber;
        this.proNumber = proNumber;
    }


}
