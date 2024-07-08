package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.noteVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface noteMapper {
    List<noteVO> selectNoteById(Long parentNumber);
}
