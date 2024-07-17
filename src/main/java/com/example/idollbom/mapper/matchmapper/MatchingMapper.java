package com.example.idollbom.mapper.matchmapper;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MatchingMapper {
    // 매칭 정보를 가져오는 select
    List<MatchingDTO> matchClass(String category,
                                 String categoryData,
                                 String selectedDate,
                                 String selectedTime);
}
