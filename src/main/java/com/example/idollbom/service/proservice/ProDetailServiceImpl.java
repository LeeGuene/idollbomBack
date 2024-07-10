package com.example.idollbom.service.proservice;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.mapper.proMapper.ProDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProDetailServiceImpl implements ProDetailService {

    private final ProDetailMapper proDetailMapper;

    // 전문가 프로필 상세보기
    @Override
    public ProDetailDTO findDetailByNumber(Long proNumber) {
        return proDetailMapper.selectProDetail(proNumber);
    }
}
