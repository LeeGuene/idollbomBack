package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ProCommentListDTO {
    private Long proCommentNumber;
    private String proCommentContent;
    private LocalDateTime proCommentRegisterDate;
    private LocalDateTime proCommentUpdateDate;
    private Long proNumber;
    private Long proPostNumber;
    private String proNickName;
}
