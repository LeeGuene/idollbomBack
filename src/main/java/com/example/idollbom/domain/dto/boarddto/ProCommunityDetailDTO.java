package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProCommunityDetailDTO {
    private int proPostNumber;
    private String proPostTitle;
    private String proPostContent;
    private String proNickName;
    private int proPostViews;
    private LocalDateTime proPostRegisterDate;
    private LocalDateTime proPostUpdateDate;
    private Long proNumber;
    private int fileCount;
    
}
