package com.example.idollbom.service.proservice;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProDetailService {
    // 전문가 프로필 상세보기
    ProDetailDTO findDetailByNumber(Long proNumber);

}
