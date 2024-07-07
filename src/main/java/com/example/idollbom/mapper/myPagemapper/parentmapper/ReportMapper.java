package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.myPagevo.parentvo.reportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

   List<reportVO> reportList();
}
