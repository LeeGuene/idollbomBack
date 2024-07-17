package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.ReservationDateVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationDateMapper {
    ReservationDateVO selectReservationDate(Long classNumber);
}
