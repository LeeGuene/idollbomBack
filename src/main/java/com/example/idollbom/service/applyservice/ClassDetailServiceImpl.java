package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.applydto.ClassDetailDTO;
import com.example.idollbom.domain.dto.parentdto.ReservationInfoDTO;
import com.example.idollbom.mapper.applymapper.ClassDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassDetailServiceImpl implements ClassDetailService {

    private final ClassDetailMapper classDetailMapper;

    // 수업 상세보기 서비스
    @Override
    public ClassDetailDTO findClassDetail(Long proNumber, Long classNumber) {
        return classDetailMapper.selectClassDetail(proNumber, classNumber);
    }

    // 특정 수업에 대한 모든 예약정보를 조회하는 서비스
    @Override
    public List<ReservationInfoDTO> findReservation(Long classNumber) {
        return classDetailMapper.selectReservation(classNumber);
    }
}
