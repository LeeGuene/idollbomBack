package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.myPagevo.parentvo.myPostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface myPostMapper {
   List<myPostVO> selectAll();
}
