package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.classSaveDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface classSaveService {
    List<classSaveDTO> selectClassList();
    
    // 수업 찜 목록 추가 ( 수업 상세 -> 찜 목록 이동 )
    int saveClass(Long classNumber, Long parentNumber);

    int deleteClass(Long classNumber);
}
