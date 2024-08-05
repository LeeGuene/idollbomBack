package com.example.idollbom.service.myPageservice.proservice;

import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.mapper.loginmapper.ProMapper;
import com.example.idollbom.mapper.proMapper.ProDetailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class proselectServiceImpl implements proselectService {
    private final ProMapper proMapper;
    private final ProDetailMapper proDetailMapper;
    @Override
    public ProVO selectPro() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

        //      pro VO 찾아서 아이디 찾기
        ProVO pro = proMapper.selectPro(currentUserName);
        return proDetailMapper.selectProPrivate(pro.getProNumber());
    }
}
