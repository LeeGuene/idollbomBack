package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProFileDTO {
    private Long proFileNumber;
    private String proFileOriginName;
    private String proFileName;
    private Long proFileSize;
    private LocalDateTime proFileUploadTime;
    private Long proPostNumber;
}
