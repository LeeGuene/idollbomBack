package com.example.idollbom.service.myPageservice.proservice;

import com.example.idollbom.domain.dto.logindto.ProDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface proUpdateService {
    void proPasswordUpdate(String proPassword);

    void proImgUpdate(MultipartFile file);

    void update(ProDTO proDTO);

}
