package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.prodto.ClassDTO;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class classVO {
    private Long classNumber;
    private String className;
    private String classCategoryBig;
    private String classCategorySmall;
    private String classContent;
    private Long classPaymentAccount;
    private Long proNumber;
    private LocalDateTime classRegisterDate;
    private String classIntro;
}
