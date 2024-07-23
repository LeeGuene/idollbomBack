package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.ParentFileDTO;
import com.example.idollbom.domain.vo.ParentFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentFileMapper {
    // 첨부파일 insert
    void insertFile(ParentFileDTO dto);

    // 첨부파일 삭제
    void deleteFile(Long parentPostNumber);
}
