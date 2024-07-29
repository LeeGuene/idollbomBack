package com.example.idollbom.service.loginservice;

import com.example.idollbom.domain.dto.logindto.ParentDTO;
import org.springframework.stereotype.Service;

@Service
public interface ParentService {
    public void save(ParentDTO dto);

}
