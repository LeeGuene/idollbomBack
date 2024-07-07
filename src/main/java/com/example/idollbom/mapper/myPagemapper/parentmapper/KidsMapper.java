package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.myPagevo.parentvo.kidVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KidsMapper {
    void insertKids(kidVO kidVO);
}
