package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.CommunityDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityDetailDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import com.example.idollbom.domain.vo.CommunityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    List<CommunityListDTO> selectAll(int startRow, int pageSize);

    int countCommunity();

    int getSeq();

    void saveCommunity(CommunityDTO community);

    CommunityDetailDTO selectCommunityDetail(int parentPostNumber);

    void plusView(int parentPostNumber);

    void updateCommunity(CommunityVO communityVO);

    void deleteCommunity(int parentPostNumber);

    List<CommunityListDTO> selectAllByDateASC(int startRow, int endRow);

    List<CommunityListDTO> selectAllByViews(int startRow, int endRow);

    List<CommunityListDTO> selectD(int startRow, int endRow, String sort, String searchType, String search);

    int countDCommunity(String searchType, String search);


}


