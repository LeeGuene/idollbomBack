package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.mapper.proMapper.ProDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProDetailServiceImpl implements ProDetailService {

    private final ProDetailMapper proDetailMapper;

    // 전문가 프로필 상세보기 및 전체리뷰 조회 서비스
    @Override
    public ProDetailDTO findProDetailByNumber(Long proNumber) {
        return proDetailMapper.selectProDetail(proNumber);
    }

    // 전문가 전체 리뷰 조회하기
    @Override
    public List<ProReviewListDTO> findAllReviewList(Long proNumber) {
        return proDetailMapper.selectAllReviewList(proNumber);
    }

    // 전문가 로그인 정보를 넘겨서 아이찾기 테스트
    @Override
    public ProVO findProInfo(Long proNumber) {
        return proDetailMapper.selectOne(proNumber);
    }
}
