package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ChildFindDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChildFindService {

    // 수업을 찜한 모든 부모 리스트에 대한 페이징 처리 쿼리
    List<ChildFindDTO> findAllParent(Long proNumber, int pageNo, int pageSize);

    // 전문가의 모든 수업에 대해 찜한 부모 목록 개수 조회
    int classSaveCount(Long proNumber);
}
