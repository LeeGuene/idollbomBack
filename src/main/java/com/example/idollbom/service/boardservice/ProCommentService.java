package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ProCommentDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommentListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProCommentService {
    // 해당 게시글의 댓글 목록 보기
    List<ProCommentListDTO> selectCommentByPro(Long proPostNumber);

    // 댓글 추가
    void insertProComment(ProCommentDTO proCommentDTO);

    // 댓글 삭제
    void deleteProComment(Long proCommentNumber);

    // 댓글 수정
    void updateProComment(ProCommentDTO proCommentDTO);
}
