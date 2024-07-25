package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.ParentCommentDTO;
import com.example.idollbom.domain.dto.boarddto.ParentCommentListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParentCommentMapper {

    // 해당 게시글의 댓글 목록 보기
    List<ParentCommentListDTO> selectCommentById(Long parentPostNumber);

    // 댓글 추가
    void insertComment(ParentCommentDTO parentCommentDTO);

    // 댓글 삭제
    void deleteComment(Long parentCommentNumber);

    // 댓글 수정
    void updateComment(ParentCommentDTO parentCommentDTO);

}
