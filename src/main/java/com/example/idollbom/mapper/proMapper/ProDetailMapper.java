package com.example.idollbom.mapper.proMapper;

import com.example.idollbom.domain.dto.parentdto.ProListDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.domain.dto.prodto.proReportDTO;
import com.example.idollbom.domain.vo.ProPostVO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.domain.vo.classVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProDetailMapper {

    // 전문가 프로필 상세보기
    ProDetailDTO selectProDetail(Long proNumber);

    // 전문가 전체 리뷰 조회하기
    List<ProReviewListDTO> selectAllReviewList(Long proNumber);

    // 전문가 로그인 정보를 넘겨서 아이찾기 테스트
    ProVO selectOne(Long proNumber);

    // 전문가 전체 수업 조회하기
    List<classVO> selectMyClass(Long proNumber);

    // 전문가 신고목록 조회하기
    List<proReportDTO> selectProReport(Long proNumber);

    // 전문가 게시글 조회
    List<ProPostVO> selectProPost(Long proNumber);

    // 전문가 개인정보 조회
    ProVO selectProPrivate(Long proNumber);

    ProDetailDTO selectOneDTO(String proEmail);

    // 전문가 리스트 조회
    List<ProListDTO> selectAllProList(int startRow, int endRow);

    // 전문가 총 인원수 조회
    int getProCount();

    // 전문가 이미지 업데이트
    void updateImg(@Param("proNumber") Long proNumber, @Param("proProfileImageUrl") String proProfileImageUrl);

    // 전문가 정보 전체 업데이트
    void update(ProVO proVO);

    // 전문가 file 업데이트
    void updateFile(@Param("proNumber") Long proNumber, @Param("proFile") String proFile);

    ProVO selectPrifile(Long proNumber);
}
