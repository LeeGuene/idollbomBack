package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.paymentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface paymentService {
    public List<paymentDTO> paymentList();
}
