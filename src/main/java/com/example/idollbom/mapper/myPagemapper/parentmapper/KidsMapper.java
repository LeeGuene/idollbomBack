package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.myPagevo.parentvo.kidVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KidsMapper {
    void insertKids(kidVO kidVO);

    List<kidVO> selectKidsList();
}
