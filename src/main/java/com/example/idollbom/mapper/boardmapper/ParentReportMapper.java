package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.ParentReportDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentReportMapper {
    // 신고하기 insert
    void insertReport(ParentReportDTO parentReportDTO);

    // 어떤 게시글의 작성자인지 select
    ParentReportDTO selectParentById(Long parentPostNumber);

    // 신고된 작성자 update
    void plusReport(Long parentNumber);

    // 게시글 신고횟수 COUNT
    void plusPost(Long parentPostNumber);
}
