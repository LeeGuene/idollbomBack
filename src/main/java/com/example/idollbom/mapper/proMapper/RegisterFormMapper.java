package com.example.idollbom.mapper.proMapper;

import com.example.idollbom.domain.dto.prodto.ClassDTO;
import com.example.idollbom.domain.dto.prodto.ClassImgDTO;
import com.example.idollbom.domain.dto.prodto.ReservationDateDTO;
import com.example.idollbom.domain.dto.prodto.ReservationTimeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterFormMapper {
    // 현재 시퀀스 값을 불러오는 select
    Long currentSeq();

    // 수업 등록하는 insert
    void classInsert(ClassDTO classDTO);

    // 수업 날짜 등록 insert
    void classDateInsert(ReservationDateDTO resDateDTO);

    // 수업 시간 등록 insert
    void classTimeInsert(ReservationTimeDTO resTimeDTO);

    // 수업 이미지 insert
    void imageInsert(ClassImgDTO classImgDTO);
}
