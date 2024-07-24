package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ParentCommentDTO;
import com.example.idollbom.domain.dto.boarddto.ParentCommentListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParentCommentService {
    // 해당 게시글의 댓글 목록 보기
    List<ParentCommentListDTO> getCommentById(Long parentPostNumber);

    // 댓글 추가
    void saveComment(ParentCommentDTO parentCommentDTO);

}
