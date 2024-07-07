package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import org.springframework.stereotype.Service;

@Service
public interface kidsService {
    public void insertKids(kidDTO kidDTO);
}
