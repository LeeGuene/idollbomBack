package com.example.idollbom.service.boardservice;

import org.springframework.stereotype.Service;

@Service
public interface ProReportService {
    void saveProReport(Long proPostNumber, String reportType, String reportForm);
}
