package com.example.idollbom.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@NoArgsConstructor
public class ReservationVO {

    private Long reservationDateNumber;
    private Long reservationTimeNumber;
    private Long parentNumber;
    private Long childNumber;

    @Builder
    public ReservationVO (Long reservationDateNumber, Long reservationTimeNumber, Long parentNumber, Long childNumber) {
        this.reservationDateNumber = reservationDateNumber;
        this.reservationTimeNumber = reservationTimeNumber;
        this.parentNumber = parentNumber;
        this.childNumber = childNumber;
    }



}
