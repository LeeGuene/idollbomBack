package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import com.example.idollbom.domain.dto.recommend.PagedResponse;
import jdk.jfr.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassListService {
    // 소카에 대한 전체 클래스 목록 select
    List<ClassListDTO> findAllClass(String category, int PageNo, int pageSize);

    // 소카에 대한 갯수 가져오기
    int classCount(String category);

    // 검색 구현 select
    PagedResponse<ClassListDTO> searchClassList(String searchWord, String searchType, String category, int PageNo, int pageSize);

    // 검색한 수업에 대한 갯수를 가져오는 select
    int countClasses(String category, String searchType, String searchWord);
}
