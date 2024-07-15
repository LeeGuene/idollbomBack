package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import com.example.idollbom.mapper.boardmapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityMapper communityMapper;

    @Override
    public List<CommunityListDTO> getCommunityList(int page, int pageSize) {

        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        return communityMapper.selectAll(startRow, endRow);
    }

    @Override
    public int getCommunityListCount() {
        return communityMapper.countCommunity();
    }
}
