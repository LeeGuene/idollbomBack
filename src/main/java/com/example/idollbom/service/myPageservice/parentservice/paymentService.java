package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.paymentDTO;
import com.example.idollbom.domain.dto.paymentdto.PayDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface paymentService {
    public List<paymentDTO> paymentList();

    // 결제하기
    void payInsert(PayDTO payDTO);
}
