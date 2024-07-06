package com.example.idollbom.service.loginservice;

import com.example.idollbom.mapper.loginmapper.ParentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentDetailService implements UserDetailsService {

    private final ParentMapper userMapper;
//    username 이 사실상 아이디
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.selectOne(username);
    }
}
