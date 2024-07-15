package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationTimeDTO {
    private LocalDateTime reservationTime;
    private Long reservationDateNumber;
}
