package com.example.idollbom.service.loginservice;

import com.example.idollbom.domain.vo.ProVO;
import org.springframework.stereotype.Service;

@Service
public interface ProService {

    // 프로 pk 가져오기
    ProVO selectPro(String proId);

}
