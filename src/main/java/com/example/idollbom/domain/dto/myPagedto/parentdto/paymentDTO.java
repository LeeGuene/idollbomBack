package com.example.idollbom.domain.dto.myPagedto.parentdto;

import lombok.Data;

import java.util.Date;

@Data
public class paymentDTO {
    private Long classNumber;
    private String className;
    private Date reservationDate;
    private Long classPaymentAccount;
    private String proName;
    private Long proNumber;
    private Long reviewCompleted;

}
