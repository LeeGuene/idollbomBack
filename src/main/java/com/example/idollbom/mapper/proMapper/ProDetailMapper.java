package com.example.idollbom.mapper.proMapper;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.domain.dto.prodto.proReportDTO;
import com.example.idollbom.domain.vo.ProPostVO;
import com.example.idollbom.domain.vo.classVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProDetailMapper {

    // 전문가 프로필 상세보기
    ProDetailDTO selectProDetail(Long proNumber);

    // 전문가 전체 리뷰 조회하기
    List<ProReviewListDTO> selectAllReviewList(Long proNumber);

    // 전문가 전체 수업 조회하기
    List<classVO> selectMyClass(Long proNumber);

    // 전문가 신고목록 조회하기
    List<proReportDTO> selectProReport(Long proNumber);

    // 전문가
    List<ProPostVO> selectProPost(Long proNumber);

}
