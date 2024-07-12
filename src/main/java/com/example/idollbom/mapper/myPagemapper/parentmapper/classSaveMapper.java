package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.dto.myPagedto.parentdto.classSaveDTO;
import com.example.idollbom.domain.vo.classSaveVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface classSaveMapper {
    //  수업 찜 목록 가져오기
    List<classSaveDTO> selectAll(Long parentId);

    // 수업 찜 목록 추가
    int insertClass(Long classNumber, Long parentNumber);

    // 수업 찜 목록 삭제
    void deleteClass(Long classNumber);
    // 수업 찜 목록 추가 ( 쿼리문 수정해야 됨. )
}
