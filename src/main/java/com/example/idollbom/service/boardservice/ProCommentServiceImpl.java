package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ProCommentDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommentListDTO;
import com.example.idollbom.mapper.boardmapper.ProCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProCommentServiceImpl implements ProCommentService {

    private final ProCommentMapper proCommentMapper;

    @Override
    public List<ProCommentListDTO> selectCommentByPro(Long proPostNumber) {
        return proCommentMapper.selectCommentByPro(proPostNumber);
    }

    @Override
    public void insertProComment(ProCommentDTO proCommentDTO) {
        proCommentMapper.insertProComment(proCommentDTO);
    }

    @Override
    public void deleteProComment(Long proCommentNumber) {
        proCommentMapper.deleteProComment(proCommentNumber);
    }

    @Override
    public void updateProComment(ProCommentDTO proCommentDTO) {
        proCommentMapper.updateProComment(proCommentDTO);
    }
}
