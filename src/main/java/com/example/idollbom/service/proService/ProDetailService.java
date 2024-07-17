package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProDetailService {

    // 전문가 프로필 상세보기 및 전체리뷰 조회 서비스
    ProDetailDTO findProDetailByNumber(Long proNumber);

    // 전문가 전체 리뷰 조회하기
    List<ProReviewListDTO> findAllReviewList(Long proNumber);
}
