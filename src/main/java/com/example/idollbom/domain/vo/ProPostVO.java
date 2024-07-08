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
public class ProPostVO {

    private Long proPostNumber;
    private String proPostTitle;
    private String proPostContent;
    private int proPostViews;
    private LocalDateTime proPostRegisterDate;
    private LocalDateTime proPostUpdateDate;
    private Long proNumber;

    @Builder
    public ProPostVO (Long proPostNumber, String proPostTitle, String proPostContent, int proPostViews, LocalDateTime proPostRegisterDate, LocalDateTime proPostUpdateDate, Long proNumber) {
        this.proPostNumber = proPostNumber;
        this.proPostTitle = proPostTitle;
        this.proPostContent = proPostContent;
        this.proPostViews = proPostViews;
        this.proPostRegisterDate = proPostRegisterDate;
        this.proPostUpdateDate = proPostUpdateDate;
        this.proNumber = proNumber;
    }



}
