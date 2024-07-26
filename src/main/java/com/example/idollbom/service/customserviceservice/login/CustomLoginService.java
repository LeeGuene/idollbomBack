package com.example.idollbom.service.customserviceservice.login;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomLoginService implements UserDetailsService {

    private final ParentMapper parentMapper;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("들어옴.");
        ParentDTO parentDTO = parentMapper.selectOneDTO(email);

        System.out.println(parentDTO);

        if (parentDTO != null) {
            return new CustomUserDTO(parentDTO.getParentEmail(), parentDTO.getParentPassword(), parentDTO.getRole());
        }

//        Expert expert = expertRepository.findByUsername(username);
//        if (expert != null) {
//            return new org.springframework.security.core.userdetails.User(expert.getUsername(), expert.getPassword(), expert.getRole());
//        }

        throw new UsernameNotFoundException("User not found with username: " + email);


    }
}
