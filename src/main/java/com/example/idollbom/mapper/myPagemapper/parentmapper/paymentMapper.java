package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.dto.myPagedto.parentdto.paymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface paymentMapper {
    List<paymentDTO> selectAll(Long parentNumber);
}
