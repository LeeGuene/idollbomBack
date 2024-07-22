package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.parentdto.ReviewAllListDTO;
import com.example.idollbom.domain.dto.parentdto.ReviewDTO;
import com.example.idollbom.domain.dto.parentdto.ReviewOneListDTO;
import com.example.idollbom.domain.vo.reviewVO;
import com.example.idollbom.mapper.applymapper.ClassReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassReviewServiceImpl implements ClassReviewService {

    private final ClassReviewMapper classReviewMapper;

    // 특정 전문가의 하나의 수업에 대한 모든 리뷰를 조회하는 서비스
    @Override
    public List<ReviewOneListDTO> findOneReviewList(Long classNumber) {
        return classReviewMapper.selectOneAllReview(classNumber);
    }

}
