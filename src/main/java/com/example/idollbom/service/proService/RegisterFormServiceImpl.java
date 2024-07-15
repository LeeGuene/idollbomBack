package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ClassDTO;
import com.example.idollbom.domain.dto.prodto.ReservationDateDTO;
import com.example.idollbom.domain.dto.prodto.ReservationTimeDTO;
import com.example.idollbom.mapper.proMapper.RegisterFormMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterFormServiceImpl implements RegisterFormService {

    private final RegisterFormMapper registerFormMapper;

    @Override
    @Transactional
    public void registerClass(ClassDTO classDTO, ReservationDateDTO reservationDateDTO, ReservationTimeDTO resTimeDTO) {
        registerFormMapper.classInsert(classDTO);
        // 현재 class pk를 받아옴
        // 이미지 테이블에 들어가야하는 코드 필요
        Long classNumber = registerFormMapper.currentSeq();
        reservationDateDTO.setClassNumber(classNumber);
        registerFormMapper.classDateInsert(reservationDateDTO);

        // 현재 reservationNumber를 받아옴
        Long reservationNumber = registerFormMapper.currentSeq();
        resTimeDTO.setReservationDateNumber(reservationNumber);
        registerFormMapper.classTimeInsert(resTimeDTO);
    }
}
