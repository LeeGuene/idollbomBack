package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.NoteListDTO;
import com.example.idollbom.domain.dto.myPagedto.parentdto.mailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface noteService {
    List<mailDTO> selectAllMyNote();

    mailDTO selectOneMail(Long mailid);

    // 전문가 쪽지 목록 조회
    List<NoteListDTO> findAllMyProNote(Long proNumber);

    // 전문가 쪽지 목록 카운트
    int countProNoteList(Long proNumber);

    // 부모 쪽지 목록 카운트
    int countParentNoteList(Long parentNumber);
    
}
