package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

// 전문가 프로필 보기에 뿌려줄 DTO
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

}
