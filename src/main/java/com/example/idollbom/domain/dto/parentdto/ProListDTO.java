package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProListDTO {

    private Long proNumber;                 // 전문가 pk
    private String proEmail;
    private String proPassword;
    private String proName;                 // 전문가 이름
    private String proNickName;
    private String proPhoneNumber;
    private String proAddress;
    private String proProfileImageUrl;      // 전문가 이미지
    private String proFile;                 // 첨부파일
    private String proIntro;
}
