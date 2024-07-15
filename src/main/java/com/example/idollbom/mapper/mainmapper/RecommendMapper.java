package com.example.idollbom.mapper.mainmapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommendMapper {

    // 전문가 추천
    int recommend(String recommend);

}
