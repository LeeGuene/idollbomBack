package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunityService {

    List<CommunityListDTO> getCommunityList(int page, int pageSize);

    int getCommunityListCount();




}