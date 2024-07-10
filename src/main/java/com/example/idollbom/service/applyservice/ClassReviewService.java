package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.parentdto.ReviewListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassReviewService {
    // 특정 전문가의 특정 수업의 모든 리뷰를 조회하는 서비스
    List<ReviewListDTO> findAllReviewList(Long classNumber);

}
