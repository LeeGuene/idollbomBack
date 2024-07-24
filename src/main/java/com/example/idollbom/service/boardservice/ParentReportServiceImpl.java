package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ParentCommentListDTO;
import com.example.idollbom.domain.dto.boarddto.ParentReportDTO;
import com.example.idollbom.mapper.boardmapper.ParentReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParentReportServiceImpl implements ParentReportService {

    private final ParentReportMapper parentReportMapper;

    @Override
    @Transactional
    public void saveParentReport(Long parentPostNumber, String reportType, String reportForm) {
        // 먼저, 신고하기 테이블에 추가
        ParentReportDTO parentReportDTO = new ParentReportDTO();
        parentReportDTO.setParentReportType(reportType);
        parentReportDTO.setParentReportContent(reportForm);
        parentReportDTO.setParentPostNumber(parentPostNumber);
        parentReportMapper.insertReport(parentReportDTO);

        // 해당 게시글의 작성자가 누구인지 select
        ParentReportDTO parentId = parentReportMapper.selectParentById(parentPostNumber);
        System.out.println(parentId);

        // 해당 부모 신고횟수 +1
        parentReportMapper.plusReport(parentId.getParentNumber());

    }
}
