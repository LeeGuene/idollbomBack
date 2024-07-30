package com.example.idollbom.mapper.myPagemapper.parentmapper;
import com.example.idollbom.domain.vo.ParentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface infoMapper {
    ParentVO selectMyInfo(Long parentNumber);

    void updatePassword(@Param("parentNumber") Long parentNumber,@Param("parentPassword")  String password);
}
