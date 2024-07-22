package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.vo.reviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
   List<reviewVO> selectAll(Long parentNumber);

   void insertReview(reviewVO reviewVO);
}
