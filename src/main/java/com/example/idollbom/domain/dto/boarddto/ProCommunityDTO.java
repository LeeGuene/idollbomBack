package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class ProCommunityDTO {
    private Long proPostNumber;
    private String proPostTitle;
    private String proPostContent;
    private int proPostViews;
    private LocalDateTime proPostRegisterDate;
    private LocalDateTime proPostUpdateDate;
    private Long proNumber;
}
