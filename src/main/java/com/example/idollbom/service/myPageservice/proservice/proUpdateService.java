package com.example.idollbom.service.myPageservice.proservice;

import com.example.idollbom.domain.dto.logindto.ProDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface proUpdateService {
    void proPasswordUpdate(String proPassword);

    void proImgUpdate(MultipartFile file);

    void update(ProDTO proDTO, MultipartFile file);

    // 여러 개의 첨부파일 등록하는 메소드
    void saveProFile(Long proNumber, MultipartFile profiles);
}
