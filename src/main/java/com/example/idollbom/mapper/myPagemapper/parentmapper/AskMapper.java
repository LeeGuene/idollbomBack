package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.askVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AskMapper {
   List<askVO> selectAll(Long parentNumber);
}
