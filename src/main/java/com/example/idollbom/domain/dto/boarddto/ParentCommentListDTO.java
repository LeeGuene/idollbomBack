package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ParentCommentListDTO {
    private Long parentCommentNumber;
    private String parentCommentContent;
    private LocalDateTime parentCommentRegisterDate;
    private LocalDateTime parentCommentUpdateDate;
    private Long parentNumber;
    private Long parentPostNumber;
    private String parentNickName;
}
