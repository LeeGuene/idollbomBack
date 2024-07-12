package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.classSaveDTO;
import com.example.idollbom.domain.vo.classSaveVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface classSaveService {
    List<classSaveDTO> selectClassList();

    int saveClass(Long classNumber, Long parentNumber);

    void deleteClass(Long classNumber);
}
