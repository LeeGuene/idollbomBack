package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import com.example.idollbom.mapper.proMapper.childFindMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildFindServiceImpl implements ChildFindService {

    private final childFindMapper childFindMapper;

    // 특정 전문가의 수업에 대해 찜한 부모 리스트 전체조회
    @Override
    public List<ChildFindDTO> findAllParent(Long proNumber) {
        return childFindMapper.selectAllParent(proNumber);
    }
}
