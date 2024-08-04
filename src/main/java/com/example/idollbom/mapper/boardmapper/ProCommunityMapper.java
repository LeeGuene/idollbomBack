package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.ProCommunityDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommunityDetailDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommunityListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProCommunityMapper {
    // 현재 시퀀스 불러오기
    int getProSeq();

    // 전문가 게시글 작성
    void saveProCommunity(ProCommunityDTO pro);

    // 페이징 처리를 위한 게시글 갯수
    int countSearchProCommunity(String searchType, String searchWord);

    // 페이징 처리한 리스트 목록 SELECT
    List<ProCommunityListDTO> searchProCommunityList(String searchType, String searchWord, int startRow, int endRow);

    // 게시글 상세보기
    ProCommunityDetailDTO selectProCommunityDetail(Long proPostNumber, Long proNumber);

    // 게시글 삭제
    void deleteProCommunity(Long proPostNumber);

    // 게시글 수정
    void updateProCommunity(ProCommunityDTO pro);

    // 조회수 +1
    void plusProView(Long proPostNumber);
}
