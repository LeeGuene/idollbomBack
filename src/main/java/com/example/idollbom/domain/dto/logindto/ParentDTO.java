package com.example.idollbom.domain.dto.logindto;

import lombok.Data;

@Data
public class ParentDTO {
    private Long parentNumber;
    private String parentEmail;
    private String parentPassword;
    private String parentName;
    private String parentNickname;
    private String parentPhoneNumber;
    private String parentAddress;
    private String parentProfileImageUrl;
    private String parentReportCount;
}
