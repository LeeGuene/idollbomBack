package com.example.idollbom.mapper.loginmapper;
import com.example.idollbom.domain.vo.loginvo.ParentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentMapper {
     void insert(ParentVO vo);
     ParentVO selectOne(String userId);
}
