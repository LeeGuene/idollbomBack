package com.example.idollbom.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
public class ProReportVO {

    private Long proReportNumber;
    private String proReportType;
    private String proReportContent;
    private String proReportRegisterDate;
    private Long proPostNumber;

    @Builder
    public ProReportVO(Long proReportNumber, String proReportType, String proReportContent, String proReportRegisterDate, Long proPostNumber) {
        this.proReportNumber = proReportNumber;
        this.proReportType = proReportType;
        this.proReportContent = proReportContent;
        this.proReportRegisterDate = proReportRegisterDate;
        this.proPostNumber = proPostNumber;
    }



}
