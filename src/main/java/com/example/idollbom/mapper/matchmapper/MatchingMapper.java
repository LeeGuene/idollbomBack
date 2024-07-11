package com.example.idollbom.mapper.matchmapper;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MatchingMapper {
    // 매칭 정보를 가져오는 select
    MatchingDTO matchClass();
}
