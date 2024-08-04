package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommunityDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommunityDetailDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommunityListDTO;
import com.example.idollbom.domain.dto.recommend.PagedResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ProCommunityService {
    void saveProFile(Long proPostNumber, List<MultipartFile> files);

    // 전문가 게시글 작성
    void saveProCommunity(ProCommunityDTO pro, List<MultipartFile> files, Long proNumber);

    // 비동기 처리로 리스트 불러오기
    PagedResponse<ProCommunityListDTO> searchProCommunityList(String searchType, String searchWord, int startRow, int endRow);

    // 게시글 상세보기
    ProCommunityDetailDTO selectProCommunityDetail(Long proPostNumber, Long proNumber);

    // 게시글 삭제
    void deleteProCommunity(Long proPostNumber);

    // 게시글 수정
    void updateProCommunity(ProCommunityDTO pro, List<MultipartFile> files);
}
