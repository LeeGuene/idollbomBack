package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.CommunityDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

//    게시글 목록
    List<CommunityListDTO> selectAll(int startRow, int endRow);
//    게시판 총 갯수
    int countCommunity();
//    게시글 작성때 사용할 쿼리
    int getSeq();
//    게시글 작성
    void saveCommunity(CommunityDTO community);
}


