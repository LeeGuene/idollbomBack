package com.example.idollbom.service.loginservice;

import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.mapper.loginmapper.ProMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProServiceImpl implements ProService {

    private final ProMapper proMapper;

    @Override
    public ProVO selectPro(String proId) {
        return proMapper.selectPro(proId);
    }
}
