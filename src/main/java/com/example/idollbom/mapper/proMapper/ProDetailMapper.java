package com.example.idollbom.mapper.proMapper;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProDetailMapper {

    // 전문가 프로필 상세보기
    ProDetailDTO selectProDetail(Long proNumber);

    // 전문가 전체 리뷰 조회하기
    List<ProReviewListDTO> selectAllReviewList(Long proNumber);
}
