package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDateDTO {
    private LocalDate reservationDate;
    private Long classNumber;
}
