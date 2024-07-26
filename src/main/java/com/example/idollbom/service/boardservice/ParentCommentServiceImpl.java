package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ParentCommentDTO;
import com.example.idollbom.domain.dto.boarddto.ParentCommentListDTO;
import com.example.idollbom.mapper.boardmapper.ParentCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentCommentServiceImpl implements ParentCommentService {

    private final ParentCommentMapper parentCommentMapper;

    @Override
    public List<ParentCommentListDTO> getCommentById(Long parentPostNumber) {
        return parentCommentMapper.selectCommentById(parentPostNumber);
    }

    @Override
    public void saveComment(ParentCommentDTO parentCommentDTO) {
        parentCommentMapper.insertComment(parentCommentDTO);
    }

    @Override
    public void deleteComment(Long parentCommentNumber) {
        parentCommentMapper.deleteComment(parentCommentNumber);
    }

    @Override
    public void updateComment(ParentCommentDTO parentCommentDTO) {
        parentCommentMapper.updateComment(parentCommentDTO);
    }
}
