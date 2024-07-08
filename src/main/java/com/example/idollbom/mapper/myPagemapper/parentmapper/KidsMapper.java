package com.example.idollbom.mapper.myPagemapper.parentmapper;

import com.example.idollbom.domain.vo.kidVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KidsMapper {
//   아이 등록
    void insertKids(kidVO kidVO);

//   내 아이 목록 가져오기
    List<kidVO> selectKidsList();

//   내 아이 삭제
    void deleteKids(Long kidNumber);

//   내 아이 id 로 가져오기
    kidVO selectByKidsId (Long kidNumber);

//   내 아이정보 update
    void updateByKidId(kidVO kid);
}
