package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CommunityDetailDTO {

    private int parentPostNumber;
    private String parentPostTitle;
    private String parentPostContent;
    private String parentNickName;
    private int parentPostViews;
    private LocalDateTime parentPostRegisterDate;
    private LocalDateTime parentPostUpdateDate;
    private Long parentNumber;
    private int fileCount;

}
