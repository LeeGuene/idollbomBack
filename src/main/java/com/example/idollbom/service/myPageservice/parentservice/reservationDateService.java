package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.ReservationDateVO;
import org.springframework.stereotype.Service;

@Service
public interface reservationDateService {
    ReservationDateVO selectReservationDate(Long classNumber);
}
