package com.example.idollbom.service.loginservice;
import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.domain.vo.ParentVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ParentService {
    public void save(ParentDTO dto);

}
