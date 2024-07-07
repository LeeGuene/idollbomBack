package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.myPagevo.parentvo.askVO;
import com.example.idollbom.domain.vo.myPagevo.parentvo.kidVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AskMapper {
   List<askVO> selectAll();
}
