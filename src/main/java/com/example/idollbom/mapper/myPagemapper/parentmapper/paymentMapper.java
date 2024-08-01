package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.dto.myPagedto.parentdto.paymentDTO;
import com.example.idollbom.domain.dto.paymentdto.PayDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface paymentMapper {
    List<paymentDTO> selectAll(Long parentNumber);

    // 결제하기
    void payInsert(PayDTO payDTO);

    // 결제한 시간 update
    void payStatus(Long reservationTimeNumber);
}
