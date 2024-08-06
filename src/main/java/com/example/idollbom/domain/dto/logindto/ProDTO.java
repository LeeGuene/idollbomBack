package com.example.idollbom.domain.dto.logindto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProDTO {
    private Long proNumber;                 // 전문가 pk
    private String proEmail;                // 이메일(아이디)
    private String proPassword;             // 비밀번호
    private String proName;                 // 이름
    private String proNickname;             // 별명
    private String proPhoneNumber;          // 휴대 전화
    private String proAddress;              // 주소
    private String proProfileImageUrl;      // 전문가 이미지
    private String proFile;                 // 첨부파일
    private String proIntro;                // 전문가 소개
    private String role;
    private Long proReportCount;
}
