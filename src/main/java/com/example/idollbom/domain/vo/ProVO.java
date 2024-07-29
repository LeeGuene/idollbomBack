package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.logindto.ProDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Getter
@ToString
@NoArgsConstructor
public class ProVO implements UserDetails {

    private Long proNumber;                 // 전문가 pk
    private String proEmail;
    private String proPassword;
    private String proName;                 // 전문가 이름
    private String proNickName;
    private String proPhoneNumber;
    private String proAddress;
    private String proProfileImageUrl;      // 전문가 이미지
    private String proFile;                 // 첨부파일
    private String proIntro;                // 전문가 소개
    private String role;

    @Builder
    public ProVO (Long proNumber, String proEmail, String proPassword, String proName, String proNickName, String proPhoneNumber, String proAddress, String proProfileImageUrl, String proFile, String proIntro, String role) {
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
        this.role = role;
    }

    public static ProVO toEntity(ProDTO dto){
        return ProVO.builder()
                .proEmail(dto.getProEmail())
                .proPassword(dto.getProPassword())
                .proName(dto.getProName())
                .proNickName(dto.getProNickName())
                .proPhoneNumber(dto.getProPhoneNumber())
                .proAddress(dto.getProAddress())
                .proProfileImageUrl(dto.getProProfileImageUrl())
                .proFile(dto.getProFile())
                .proIntro(dto.getProIntro())
                .role(dto.getRole())
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
