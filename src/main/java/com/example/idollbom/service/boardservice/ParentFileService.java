package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ParentFileDTO;
import com.example.idollbom.domain.vo.ParentFileVO;
import com.example.idollbom.mapper.boardmapper.ParentFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParentFileService {

    // 첨부파일 가져오기
    List<ParentFileDTO> selectFileList(Long parentPostNumber);

    // 첨부파일 다운로드
    ParentFileDTO getFileById(Long parentFileNumber);
}
