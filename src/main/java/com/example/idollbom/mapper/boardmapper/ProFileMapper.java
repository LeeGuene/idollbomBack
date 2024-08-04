package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.ProFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProFileMapper {
    // 첨부파일 추가
    void insertProFile(ProFileDTO proFileDTO);

    // 첨부파일 삭제
    void deleteProFile(Long proPostNumber);

    // 첨부파일 select
    List<ProFileDTO> selectProFileList(Long proPostNumber);

    // 첨부파일 다운로드
    ProFileDTO getFileProById(Long proFileNumber);
}
