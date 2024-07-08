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
public class ProFileVO {

    private Long proFileNumber;
    private String proFileName;
    private String proFileUrl;
    private int proFileSize;
    private LocalDateTime proFileUploadTime;
    private Long proPostNumber;

    @Builder
    public ProFileVO (Long proFileNumber, String proFileName, String proFileUrl, int proFileSize, LocalDateTime proFileUploadTime, Long proPostNumber) {
        this.proFileNumber = proFileNumber;
        this.proFileName = proFileName;
        this.proFileUrl = proFileUrl;
        this.proFileSize = proFileSize;
        this.proFileUploadTime = proFileUploadTime;
        this.proPostNumber = proPostNumber;
    }


}
