package com.example.idollbom.service.loginservice;

import com.example.idollbom.mapper.loginmapper.ProMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProDetailService implements UserDetailsService {

    private final ProMapper proMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return proMapper.selectPro(username);
    }

}
