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
public class ParentFileVO {

    private Long parentFileNumber;
    private String parentFileName;
    private int parentFileSize;
    private String parentFileUrl;
    private LocalDateTime parentFileUploadTime;
    private Long parentPostNumber;

    @Builder
    public ParentFileVO(Long parentFileNumber, String parentFileName, int parentFileSize, String parentFileUrl, LocalDateTime parentFileUploadTime, Long parentPostNumber) {
        this.parentFileNumber = parentFileNumber;
        this.parentFileName = parentFileName;
        this.parentFileSize = parentFileSize;
        this.parentFileUrl = parentFileUrl;
        this.parentFileUploadTime = parentFileUploadTime;
        this.parentPostNumber = parentPostNumber;
    }

}
