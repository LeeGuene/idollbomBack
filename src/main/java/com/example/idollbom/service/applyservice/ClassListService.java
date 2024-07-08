package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassListService {
    // 소카에 대한 전체 클래스 목록 select
    List<ClassListDTO> findAllClass();

    // 소카에 대한 갯수 가져오기
    int classCount();
}
