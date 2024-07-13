package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChildFindService {

    // 특정 전문가의 수업에 대해 찜한 부모 리스트 전체조회
    List<ChildFindDTO> findAllParent(Long proNumber);
}
