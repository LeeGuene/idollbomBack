package com.example.idollbom.domain.dto.myPagedto.parentdto;

import lombok.Data;

import java.util.Date;

@Data
public class paymentDTO {
    private String className;
    private Date reservationDate;
    private Long classPaymentAccount;
}
