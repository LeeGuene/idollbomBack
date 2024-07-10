package com.example.idollbom.mapper.applymapper;

import com.example.idollbom.domain.dto.parentdto.ReviewListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassReviewMapper {

    // 특정 전문가의 특정 수업의 모든 리뷰 조회
    List<ReviewListDTO> selectAllReview(Long classNumber);


}
