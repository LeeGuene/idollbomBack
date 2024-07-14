package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClassDTO {
    private String className;
    private String classCategoryBig;
    private String classCategorySmall;
    private String classContent;
    private Long classPaymentAccount;
    private Long proNumber;
    private LocalDateTime classRegisterDate;
}
