package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.parentdto.ReviewListDTO;
import com.example.idollbom.mapper.applymapper.ClassReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassReviewServiceImpl implements ClassReviewService {

    private final ClassReviewMapper classReviewMapper;

    // 특정 전문가의 특정 수업의 모든 리뷰를 조회하는 서비스
    @Override
    public List<ReviewListDTO> findAllReviewList(Long classNumber) {
        return classReviewMapper.selectAllReview(classNumber);
    }
}
