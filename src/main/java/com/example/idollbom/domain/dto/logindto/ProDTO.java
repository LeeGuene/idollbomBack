package com.example.idollbom.domain.dto.logindto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProDTO {

    private String proEmail;
    private String proPassword;
    private String proName;
    private String proNickName;
    private String proPhoneNumber;
    private String proAddress;
    private String proProfileImageUrl;
    private String proFile;
    private String proIntro;
    private String role;

}
