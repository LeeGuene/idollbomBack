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

    // 페이징 처리 된 전문가 가져오기 ( 메인페이지 )
    @Override
    public PagedResponse<RecommendListDTO> getRecommendList(int page, int pageSize) {
        
        // pageNo : 현재 선택된 페이지 번호
        // pageSize : 한 페이지 내에 보여줄 추천 전문가 정보 개수
        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;
        
        // 추천 전문가 총 인원수
        int totalPros = recommendMapper.getCount();
        int totalPages = (int) Math.ceil((double) totalPros / pageSize);

//        int pageGroupSize = 5;
//        int startPage = ((page - 1) / pageGroupSize) * pageGroupSize + 1;
//        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        // 추천 전문가에 대한 전체 리스트
        List<RecommendListDTO> pros = recommendMapper.recommend(startRow, endRow);

        return new PagedResponse<>(pros, page, totalPages, pageSize, totalPros);

    }
}
