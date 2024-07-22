package com.example.idollbom.mapper.myPagemapper.parentmapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReservationMapper {
    void insertReview(@Param("parentNumber") Long parentNumber, @Param("reservationDateNumber") Long reservationDateNumber);
}
