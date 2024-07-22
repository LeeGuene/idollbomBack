package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.ReservationDateVO;
import com.example.idollbom.mapper.myPagemapper.parentmapper.ReservationDateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class reservationDateServiceImpl implements reservationDateService {
    private final ReservationDateMapper reservationDateMapper;
    @Override
    public ReservationDateVO selectReservationDate(Long classNumber) {
        return reservationDateMapper.selectReservationDate(classNumber);
    }
}
