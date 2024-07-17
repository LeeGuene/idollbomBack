package com.example.idollbom.mapper.proMapper;

import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChildFindMapper {
    // 특정 전문가의 수업에 대해 찜한 부모 리스트 전체조회
    List<ChildFindDTO> selectAllParent(Long proNumber);
}
