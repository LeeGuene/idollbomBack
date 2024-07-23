package com.example.idollbom.mapper.applymapper;

import com.example.idollbom.domain.dto.applydto.ClassDetailDTO;
import com.example.idollbom.domain.dto.parentdto.ReservationInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassDetailMapper {

    // 특정 전문가의 특정 수업을 조회 (이미지가 포함된)
    ClassDetailDTO selectClassDetail(Long proNumber, Long classNumber);

    // 특정 수업에 대한 모든 예약정보를 조회
    List<ReservationInfoDTO> selectReservation(Long classNumber);
    
    // 특정 예약 정보 및 시간 정보 조회
    ReservationInfoDTO selectReservationInfo(Long reservationDateNumber, Long reservationTimeNumber);
}
