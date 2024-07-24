package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ParentFileDTO;
import com.example.idollbom.domain.vo.ParentFileVO;
import com.example.idollbom.mapper.boardmapper.ParentFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentFileServiceImpl implements ParentFileService {

    private final ParentFileMapper parentFileMapper;

    // 게시글에 올린 첨부파일 가져오기
    @Override
    public List<ParentFileDTO> selectFileList(Long parentPostNumber) {
        return parentFileMapper.selectFileList(parentPostNumber);
    }

    // 게시글 안 첨부파일 다운로드
    @Override
    public ParentFileDTO getFileById(Long parentFileNumber) {
        return parentFileMapper.getFileById(parentFileNumber);
    }
}
