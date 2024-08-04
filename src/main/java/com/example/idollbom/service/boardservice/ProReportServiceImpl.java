package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.ProCommunityReportDTO;
import com.example.idollbom.mapper.boardmapper.ProReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProReportServiceImpl implements ProReportService {
    
    private final ProReportMapper proReportMapper;
    
    @Override
    @Transactional
    public void saveProReport(Long proPostNumber, String reportType, String reportForm) {
        // 먼저, 신고하기 테이블에 추가
        ProCommunityReportDTO proReportDTO = new ProCommunityReportDTO();
        proReportDTO.setProReportType(reportType);
        proReportDTO.setProReportContent(reportForm);
        proReportDTO.setProPostNumber(proPostNumber);
        proReportMapper.insertProReport(proReportDTO);

        // 해당 게시글의 작성자가 누구인지 select
        ProCommunityReportDTO proId = proReportMapper.selectProById(proPostNumber);

        // 해당 전문가 신고횟수 +1
        proReportMapper.plusProReport(proId.getProNumber());

        // 해당 게시글 신고횟수 +1
        proReportMapper.plusProPost(proPostNumber);
    }
}
