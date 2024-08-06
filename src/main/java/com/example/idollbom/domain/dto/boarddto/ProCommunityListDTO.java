package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProCommunityListDTO {
    private Long proPostNumber;
    private String proPostTitle;
    private Long proNumber;
    private String proNickname;
    private String proProfileImageUrl;
    private int proPostReportCount;
}
