package com.example.idollbom.service.recommend;

import com.example.idollbom.domain.dto.recommend.PagedResponse;
import com.example.idollbom.domain.dto.recommend.RecommendListDTO;
import com.example.idollbom.mapper.mainmapper.RecommendMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendServiceImpl implements RecommendService {

    private final RecommendMapper recommendMapper;

    @Override
    public PagedResponse<RecommendListDTO> getRecommendList(int page, int pageSize) {

        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        int totalPros = recommendMapper.getCount();
        int totalPages = (int) Math.ceil((double)totalPros/pageSize);

        int pageGroupSize = 100;

        int startPage = ((page - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        List<RecommendListDTO> pros = recommendMapper.recommend(startRow, endRow);

        return new PagedResponse<>(pros, page, totalPages, pageSize, totalPros);

    }
}
