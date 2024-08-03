package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParentFileDTO {
    private Long parentFileNumber;
    private String parentFileOriginName;
    private String parentFileName;
    private Long parentFileSize;
    private LocalDateTime parentFileUploadTime;
    private Long parentPostNumber;
}
