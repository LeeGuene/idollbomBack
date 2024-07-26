package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.parentdto.ProListDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.domain.dto.prodto.ProReviewListDTO;
import com.example.idollbom.domain.vo.ProPostVO;
import com.example.idollbom.domain.vo.ProVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProDetailService {

    // 전문가 프로필 상세보기 및 전체리뷰 조회 서비스
    ProDetailDTO findProDetailByNumber(Long proNumber);

    // 전문가 전체 리뷰 조회하기
    List<ProReviewListDTO> findAllReviewList(Long proNumber);

    // 전문가 로그인 정보를 넘겨서 아이찾기 테스트
    ProVO findProInfo(Long proNumber);

    // 전문가 리스트 조회
    List<ProListDTO> findAllProList(int page, int pageSize);
    
    // 전문가 총인원 수 조회
    int getProCount();

    // 전문가 post 찾기
    List<ProPostVO> selectProPost(Long proNumber);

    // 전문가 개인정보 불러오기
    ProVO selectProPrivate(Long proNumber);
}
