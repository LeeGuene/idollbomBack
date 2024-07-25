package com.example.idollbom.mapper.mainmapper;

import com.example.idollbom.domain.dto.recommend.RecommendListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendMapper {

    // 전문가 추천
    List<RecommendListDTO> recommend(int startRow, int endRow);

    // 전문가의 총 인원수
    int getCount();

}
