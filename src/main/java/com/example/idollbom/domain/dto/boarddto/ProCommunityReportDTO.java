package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;

import java.util.Date;

@Data
public class ProCommunityReportDTO {
    private Long proReportNumber;
    private String proReportType;
    private String proReportContent;
    private Date proReportRegisterDate;
    private Long proPostNumber;
    private Long proNumber;
}
