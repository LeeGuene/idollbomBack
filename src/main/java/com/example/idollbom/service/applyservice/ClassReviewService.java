package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.parentdto.ReviewAllListDTO;
import com.example.idollbom.domain.dto.parentdto.ReviewOneListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassReviewService {

    // 특정 전문가의 특정 수업의 모든 리뷰를 조회하는 서비스
    List<ReviewOneListDTO> findOneReviewList(Long classNumber);

    // 특정 전문가에 대한 모든 수업에 대한 리뷰를 조회하는 서비스
    List<ReviewAllListDTO> findAllReviewList(Long classNumber);
}
