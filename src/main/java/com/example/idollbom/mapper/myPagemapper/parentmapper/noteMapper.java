package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.dto.myPagedto.parentdto.NoteListDTO;
import com.example.idollbom.domain.dto.myPagedto.parentdto.mailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface noteMapper {
    List<mailDTO> selectNoteById(Long parentNumber);

    mailDTO selectNoteByNoteId(Long mailId);

    // 전문가 쪽지 목록 조회
    List<NoteListDTO> selectNoteByProId(Long proNumber);

    // 전문가 쪽지 목록 카운트
    int countProNoteList(Long proNumber);

    // 부모 쪽지 목록 카운트
    int countParentNoteList(Long parentNumber);
}
