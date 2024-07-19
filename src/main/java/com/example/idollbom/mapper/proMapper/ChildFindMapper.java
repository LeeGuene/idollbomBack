package com.example.idollbom.mapper.proMapper;

import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChildFindMapper {

    // 수업을 찜한 부모 전체 리스트 조회에 대한 페이징 처리
    List<ChildFindDTO> selectAllParent(Long proNumber, int startRow, int endRow);

    // 전문가의 모든 수업에 대해 찜한 부모 목록 개수 조회
    int classSaveCount(Long proNumber);
}
