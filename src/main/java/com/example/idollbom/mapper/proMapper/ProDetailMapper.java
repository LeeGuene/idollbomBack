package com.example.idollbom.mapper.proMapper;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProDetailMapper {
    
    // 전문가 프로필 상세보기 
    ProDetailDTO selectProDetail(Long proNumber);
}
