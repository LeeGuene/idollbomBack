package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.domain.vo.kidVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.mapper.myPagemapper.parentmapper.KidsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public List<kidVO> selectKidsList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      parent VO 찾아서 아이디 찾기
        ParentVO parent = parentMapper.selectOne(currentUserName);
        return kidsMapper.selectKidsList(parent.getParentNumber());
    }

    @Override
    public void deleteKids(Long kidNumber) {
        kidsMapper.deleteKids(kidNumber);
    }

    @Override
    public kidVO selectKidById(Long kidNumber) {
        return kidsMapper.selectByKidsId(kidNumber);
    }

    @Override
    public void updateByKidId(kidDTO kid) {
       kidVO newKidInfo =  kidVO.toEntity(kid);
       log.info(newKidInfo.getChildName());
       kidsMapper.updateByKidId(newKidInfo);
    }
}
