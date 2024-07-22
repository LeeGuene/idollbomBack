package com.example.idollbom.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Getter
@ToString
@NoArgsConstructor
public class ReservationDateVO {

    private Long reservationDateNumber;
    private LocalDate reservationDate;
    private Long classNumber;

    @Builder
    public ReservationDateVO(Long reservationDateNumber, LocalDate reservationDate, Long classNumber) {
        this.reservationDateNumber = reservationDateNumber;
        this.reservationDate = reservationDate;
        this.classNumber = classNumber;
    }



}
