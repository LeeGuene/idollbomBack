package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

@Data
public class ProDetailDTO {

    private Long proNumber;
    private String proEmail;
    private String proPassword;
    private String proName;
    private String proNickName;
    private String proPhoneNumber;
    private String proAddress;
    private String proProfileImageUrl;
    private String proFile;
    private String proIntro;
    private Long parentNumber;
    private Long classNumber;

}
