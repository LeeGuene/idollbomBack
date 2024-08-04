package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ProFileDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProFileService {

    // 첨부파일 select
    List<ProFileDTO> selectProFileList(Long proPostNumber);

    // 첨부파일 다운로드
    ProFileDTO getFileProById(Long proFileNumber);
}
