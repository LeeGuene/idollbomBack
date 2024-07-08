package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import lombok.*;

import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class reportVO {
    private Long parentReportNumber;
    private String parentReportType;
    private String parentReportContent;
    private Date parentReportRegisterDate;
    private Long parentPostNumber;
}
