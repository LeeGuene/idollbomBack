package com.example.idollbom.mapper.applymapper;

import com.example.idollbom.domain.dto.parentdto.ReviewAllListDTO;
import com.example.idollbom.domain.dto.parentdto.ReviewDTO;
import com.example.idollbom.domain.dto.parentdto.ReviewOneListDTO;
import com.example.idollbom.domain.vo.reviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassReviewMapper {

    // 특정 전문가의 하나의 수업에 대한 리뷰 조회
    List<ReviewOneListDTO> selectOneAllReview(Long proNumber, Long classNumber);

    // 특정 전문가의 모든 수업에 대한 리뷰를 조회
    List<ReviewAllListDTO> selectAllReview(Long proNumber);

    // 특정 수업에 대한 모든 리뷰 조회 (비동기 통신)
    List<ReviewDTO> selectReviews(Long classNumber);

    // 특정 수업에 대한 리뷰 추가
    void insertReviews(reviewVO review);
    
    // 특정 수업에 대한 리뷰 삭제
    void deleteReviews(Long reviewNumber);
}
