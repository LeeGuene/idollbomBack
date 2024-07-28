package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.classSaveDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface classSaveService {
    List<classSaveDTO> selectClassList();
    
    // 수업 찜 목록 추가 ( 수업 상세, 신청하기 페이지에서 추가 )
    int saveClass(Long classNumber, Long parentNumber);
    
    // 수업 찜 목록 삭제 ( 신청하기 페이지 내에서 삭제 )
    int deleteSaveClass(Long classNumber, Long parentNumber);
    
    int deleteClass(Long classNumber);
}
