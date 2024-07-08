package com.example.idollbom.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
public class ProVO {

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

    @Builder
    public ProVO (Long proNumber, String proEmail, String proPassword, String proName, String proNickName, String proPhoneNumber, String proAddress, String proProfileImageUrl, String proFile, String proIntro) {
        this.proNumber = proNumber;
        this.proEmail = proEmail;
        this.proPassword = proPassword;
        this.proName = proName;
        this.proNickName = proNickName;
        this.proPhoneNumber = proPhoneNumber;
        this.proAddress = proAddress;
        this.proProfileImageUrl = proProfileImageUrl;
        this.proFile = proFile;
        this.proIntro = proIntro;
    }



}
