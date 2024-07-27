package com.example.idollbom.mapper.loginmapper;

import com.example.idollbom.domain.vo.ProVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProMapper {

    // 프로 pk 가져오기
    ProVO selectPro(String proId);
}
