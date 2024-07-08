package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.reportVO;
import com.example.idollbom.mapper.myPagemapper.parentmapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class reportServiceImpl implements reportService {

    private final ReportMapper reportMapper;
    @Override
    public List<reportVO> selectReportList() {
        return reportMapper.reportList();
    }
}
