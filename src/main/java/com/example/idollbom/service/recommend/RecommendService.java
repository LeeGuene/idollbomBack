package com.example.idollbom.service.recommend;

import com.example.idollbom.domain.dto.recommend.PagedResponse;
import com.example.idollbom.domain.dto.recommend.RecommendListDTO;
import org.springframework.stereotype.Service;

@Service
public interface RecommendService {

    // 페이징 처리 된 전문가 가져오기 ( 메인페이지 )
    PagedResponse<RecommendListDTO> getRecommendList(int page, int pageSize);
}
