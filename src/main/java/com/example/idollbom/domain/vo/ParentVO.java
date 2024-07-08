package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.logindto.ParentDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
//spring 시큐리티의 userDeatils 권한을 지정받아
//해당 객채를 사용하여 사용자의 인증 및 권한을 처리할 수 있다.
public class ParentVO implements UserDetails {
    private Long parentNumber;
    private String parentEmail;
    private String parentPassword;
    private String parentName;
    private String parentNickname;
    private String parentPhoneNumber;
    private String parentAddress;
    private String parentProfileImageUrl;
    private Long parentReportCount;

    public static ParentVO toEntity(ParentDTO parentDTO){
        return ParentVO.builder()
                .parentEmail(parentDTO.getParentEmail())
                .parentPassword(parentDTO.getParentPassword())
                .parentName(parentDTO.getParentName())
                .parentNickname(parentDTO.getParentNickname())
                .parentPhoneNumber(parentDTO.getParentPhoneNumber())
                .parentAddress(parentDTO.getParentAddress())
                .parentProfileImageUrl(parentDTO.getParentProfileImageUrl())
                .parentReportCount(parentDTO.getParentReportCount())
                .build();

    }

    //    사용자에게 부여된 권한을 반환한다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("basic"));
    }

    @Override
    public String getPassword() {
        return parentPassword;
    }

    //    원래 Password 도 있는데 이름 동일해서 안만든거    @Override
    public String getUsername() {
        return parentEmail;
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
