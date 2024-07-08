package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.ParentVO;
import org.springframework.stereotype.Service;

@Service
public interface parentInfoService {
    ParentVO selectParentInfo();
}
