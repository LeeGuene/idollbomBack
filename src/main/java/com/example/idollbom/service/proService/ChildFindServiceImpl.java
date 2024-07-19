package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import com.example.idollbom.mapper.proMapper.ChildFindMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildFindServiceImpl implements ChildFindService {

    private final ChildFindMapper childFindMapper;

    // 특정 전문가의 수업에 대해 찜한 부모 리스트 전체조회
    @Override
    public List<ChildFindDTO> findAllParent(Long proNumber, int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        return childFindMapper.selectAllParent(proNumber, startRow, endRow);
    }

    // 전문가의 모든 수업에 대해 찜한 부모 목록 개수 조회
    @Override
    public int classSaveCount(Long proNumber) {
        return childFindMapper.classSaveCount(proNumber);
    }
}
