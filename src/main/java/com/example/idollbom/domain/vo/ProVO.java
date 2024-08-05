package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.logindto.ProDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Data
@ToString
@NoArgsConstructor
public class ProVO implements UserDetails {

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
    @Builder
    public ProVO (Long proNumber, String proEmail, String proPassword, String proName, String proNickname, String proPhoneNumber, String proAddress, String proProfileImageUrl, String proFile, String proIntro, String role, Long proReportCount) {
        this.proNumber = proNumber;
        this.proEmail = proEmail;
        this.proPassword = proPassword;
        this.proName = proName;
        this.proNickname = proNickname;
        this.proPhoneNumber = proPhoneNumber;
        this.proAddress = proAddress;
        this.proProfileImageUrl = proProfileImageUrl;
        this.proFile = proFile;
        this.proIntro = proIntro;
        this.role = role;
        this.proReportCount = proReportCount;
    }

    public static ProVO toEntity(ProDTO dto){
        return ProVO.builder()
                .proNumber(dto.getProNumber())
                .proEmail(dto.getProEmail())
                .proPassword(dto.getProPassword())
                .proName(dto.getProName())
                .proNickname(dto.getProNickname())
                .proPhoneNumber(dto.getProPhoneNumber())
                .proAddress(dto.getProAddress())
                .proProfileImageUrl(dto.getProProfileImageUrl())
                .proFile(dto.getProFile())
                .proIntro(dto.getProIntro())
                .role(dto.getRole())
                .proReportCount(dto.getProReportCount())
                .build();
    }

    //    사용자에게 부여된 권한을 반환한다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("basic"));
    }

    @Override
    public String getPassword() {
        return proPassword;
    }

    //    원래 Password 도 있는데 이름 동일해서 안만든거    @Override
    public String getUsername() {
        return proEmail;
    }

    // 계정의 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정의 잠김 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 자경 증명 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정의 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }

}
