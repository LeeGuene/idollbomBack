package com.example.idollbom.mapper.applymapper;

import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassListMapper {
//    // 소카에 대한 전체 클래스 목록 select
    List<ClassListDTO> findAllClass();

    // 소카에 대한 갯수 가져오기
    int classCount();
}
