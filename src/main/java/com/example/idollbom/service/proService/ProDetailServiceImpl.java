package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.parentdto.ProListDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.domain.vo.ProPostVO;
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

    // 전문가 리스트 조회 서비스
    @Override
    public List<ProListDTO> findAllProList(int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        return proDetailMapper.selectAllProList(startRow, endRow);
    }

    @Override
    public int getProCount() {
        return proDetailMapper.getProCount();
    }

    @Override
    public List<ProPostVO> selectProPost(Long proNumber) {
        return proDetailMapper.selectProPost(proNumber);

    }

    @Override
    public ProVO selectProPrivate(Long proNumber) {
        return proDetailMapper.selectProPrivate(proNumber);
    }
}
