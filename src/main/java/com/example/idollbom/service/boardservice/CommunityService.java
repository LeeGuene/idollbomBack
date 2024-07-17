package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunityService {

//    게시글 목록
    List<CommunityListDTO> getCommunityList(int page, int pageSize);
//    게시판 총 갯수
    int getCommunityListCount();
//    게시글 작성
//    void saveCommunity(CommunityDTO community, List<MultipartFile> files);






}