package com.example.idollbom.mapper.myPagemapper.parentmapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
    void insertReview(Long parentNumber ,Long reservationDateNumber);
}
