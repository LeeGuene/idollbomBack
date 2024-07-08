package com.example.idollbom.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@ToString
@NoArgsConstructor
public class ReservationTimeVO {

    private Long reservationTimeNumber;
    private LocalDateTime reservationTime;
    private Long reservationDateNumber;

    @Builder
    public ReservationTimeVO (Long reservationTimeNumber, LocalDateTime reservationTime, Long reservationDateNumber) {
        this.reservationTimeNumber = reservationTimeNumber;
        this.reservationTime = reservationTime;
        this.reservationDateNumber = reservationDateNumber;
    }



}
