package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.ProCommunityReportDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProReportMapper {
    // 신고하기 INSERT
    void insertProReport(ProCommunityReportDTO proReportDTO);

    // 누구의 게시글인지 select
    ProCommunityReportDTO selectProById(Long proPostNumber);

    // 신고된 게시글 신고횟수 +1
    void plusProPost(Long proPostNumber);

    // 신고된 게시글 작성자 신고횟수 +1
    void plusProReport(Long proNumber);
}
