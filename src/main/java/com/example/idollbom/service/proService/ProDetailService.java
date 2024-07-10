package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProDetailService {

    // 전문가 프로필 상세보기 서비스
    ProDetailDTO findProDetailByNumber(Long proNumber);

}
