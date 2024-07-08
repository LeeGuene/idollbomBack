package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.askVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface askService {
    public List<askVO> selectAskList();
}
