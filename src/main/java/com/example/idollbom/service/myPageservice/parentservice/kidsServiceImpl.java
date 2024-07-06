package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import com.example.idollbom.domain.vo.loginvo.ParentVO;
import com.example.idollbom.domain.vo.myPagevo.parentvo.kidVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.mapper.myPagemapper.parentmapper.KidsMapper;
import com.example.idollbom.service.loginservice.ParentDetailService;
import com.example.idollbom.service.loginservice.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class kidsServiceImpl implements kidsService {

    private final KidsMapper kidsMapper;
    private final ParentMapper parentMapper;
    @Override
    public void insertKids(kidDTO kidDTO) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        유저id
        String username = ((UserDetails) principal).getUsername();


        ParentVO userNumber = parentMapper.selectOne(username);
        kidDTO.setParentNumber(userNumber.getParentNumber());

        kidsMapper.insertKids(kidVO.toEntity(kidDTO));
    }
}
