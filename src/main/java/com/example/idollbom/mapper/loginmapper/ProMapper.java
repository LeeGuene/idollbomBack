package com.example.idollbom.mapper.loginmapper;

import com.example.idollbom.domain.vo.ProVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProMapper {

    // 전문가 회원가입
    int insert(ProVO proVO);

    // 프로 pk 가져오기
    ProVO selectPro(String proId);

    // 전문가 정보 수정
    void updatePassword(@Param("proPassword") String proPassword, @Param("proNumber")Long proNumber);

    String selectEmail(@Param("proEmail")String proEmail);
}
