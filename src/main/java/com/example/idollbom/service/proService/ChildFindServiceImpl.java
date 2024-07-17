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

    @Override
    public List<ChildFindDTO> findAllParent(Long proNumber) {

        return childFindMapper.selectAllParent(proNumber);
    }
}
