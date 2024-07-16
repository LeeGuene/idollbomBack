package com.example.idollbom.domain.dto.parentdto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 수업 상세보기에서 예약정보를 뿌려줄 때 사용하는 DTO
@Component
@Data
public class ReservationInfoDTO {

    private Long reservationDateNumber;
    private Long classNumber;
    private LocalDate reservationDate;
    private String reservationTime;

}
