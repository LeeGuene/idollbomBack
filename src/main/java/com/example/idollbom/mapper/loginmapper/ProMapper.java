package com.example.idollbom.mapper.loginmapper;

import com.example.idollbom.domain.vo.ProVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProMapper {

    // 전문가 회원가입
    void insert(ProVO proVO);

    // 프로 pk 가져오기
    ProVO selectPro(String proId);
}
