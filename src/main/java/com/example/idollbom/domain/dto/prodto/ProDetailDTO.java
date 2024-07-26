package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

@Data
public class ProDetailDTO {
    private Long proNumber;
    private String proEmail;
    private String proPassword;
    private String proNickname;
    private String proName;
    private String proPhoneNumber;
    private String proAddress;
    private String proProfileImageUrl;
    private String proFile;
    private String proIntro;
    private Long parentNumber;
    private Long classNumber;
    private String role;
}
