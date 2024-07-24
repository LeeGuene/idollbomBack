package com.example.idollbom.domain.dto.boarddto;

import lombok.Data;

import java.util.Date;

@Data
public class ParentReportDTO {
    private Long parentReportNumber;
    private String parentReportType;
    private String parentReportContent;
    private Date parentReportRegisterDate;
    private Long parentPostNumber;
    private Long parentNumber;
}
