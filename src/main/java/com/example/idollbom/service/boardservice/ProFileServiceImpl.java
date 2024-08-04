package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ProFileDTO;
import com.example.idollbom.mapper.boardmapper.ProFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProFileServiceImpl implements ProFileService {

    private final ProFileMapper proFileMapper;

    // 게시글 작성 시 올린 첨부파일 가져오기
    @Override
    public List<ProFileDTO> selectProFileList(Long proPostNumber) {
        return proFileMapper.selectProFileList(proPostNumber);
    }

    // 게시글 안 첨부파일 다운로드
    @Override
    public ProFileDTO getFileProById(Long proFileNumber) {
        return proFileMapper.getFileProById(proFileNumber);
    }
}
