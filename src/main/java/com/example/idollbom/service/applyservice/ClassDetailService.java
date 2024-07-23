package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.applydto.ClassDetailDTO;
import com.example.idollbom.domain.dto.parentdto.ReservationInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassDetailService {
    // 수업 상세보기 서비스
    ClassDetailDTO findClassDetail(Long proNumber, Long classNumber);
    
    // 특정 수업에 대한 모든 예약정보(날짜, 시간) 조회
    List<ReservationInfoDTO> findReservation(Long classNumber);

    // 특정 예약 정보 및 시간 정보 조회
    ReservationInfoDTO findReservationInfo(Long reservationDateNumber, Long reservationTimeNumber);

}
