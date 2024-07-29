package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.dto.myPagedto.parentdto.classSaveDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface classSaveMapper {
    //  수업 찜 목록 가져오기
    List<classSaveDTO> selectAll(Long parentId);

    // 수업 찜 목록 추가 ( 수업 상세보기, 신청하기 페이지에서 추가 )
    int insertClassSave(Long classNumber, Long parentNumber);

    // 수업 찜 목록 삭제 ( 신청하기 페이지 내에서 삭제 )
    int deleteClassSave(Long classNumber, Long parentNumber);

    // 수업 찜 목록 삭제
    int deleteClass(Long classNumber);
}
