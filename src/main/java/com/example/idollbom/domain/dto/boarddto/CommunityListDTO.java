package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CommunityListDTO {

    private int parentPostNumber;
    private String parentPostTitle;
    private int parentNumber;
    private String parentNickname;
    private String parentProfileImageUrl;
}
