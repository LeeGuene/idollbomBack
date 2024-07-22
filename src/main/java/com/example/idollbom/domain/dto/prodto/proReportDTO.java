package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

import java.util.Date;

@Data
public class proReportDTO {
    private String proPostTitle;
    private Long proPostNumber;
    private String proReportContent;
    private Date proReportRegisterDate;
}
