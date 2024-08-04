package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.*;
import com.example.idollbom.domain.dto.recommend.PagedResponse;
import com.example.idollbom.mapper.boardmapper.ProCommunityMapper;
import com.example.idollbom.mapper.boardmapper.ProFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProCommunityServiceImpl implements ProCommunityService {

    private final ProCommunityMapper proCommunityMapper;
    private final ProFileMapper proFileMapper;

    // 게시글 비동기로 리스트 불러오기
    @Override
    public PagedResponse<ProCommunityListDTO> searchProCommunityList(String searchType, String searchWord, int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        int totalBoards = proCommunityMapper.countSearchProCommunity(searchType, searchWord);
        int totalPages = (int) Math.ceil((double) totalBoards / pageSize);

        List<ProCommunityListDTO> proCommunityListDTO = proCommunityMapper.searchProCommunityList(searchType, searchWord, startRow, endRow);

        return new PagedResponse<>(proCommunityListDTO, page, totalPages, pageSize, totalBoards);
    }

    // 전문가 자유게시판 등록 구현
    @Override
    @Transactional
    public void saveProCommunity(ProCommunityDTO pro, List<MultipartFile> files, Long proNumber) {
        int proPostNumber = proCommunityMapper.getProSeq();
        pro.setProPostNumber((long) proPostNumber);
        pro.setProNumber(proNumber);

        proCommunityMapper.saveProCommunity(pro);
        saveProFile(pro.getProPostNumber(), files);
    }

    // 여러 개의 첨부파일 등록하는 메소드
    @Override
    public void saveProFile(Long proPostNumber, List<MultipartFile> profiles) {
        for (MultipartFile file : profiles) {
            // 방어코드
            if (file.isEmpty()) continue; // 파일이 비어있으면 건너뜀

            String originalFileName = file.getOriginalFilename();
            String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;
            Long fileSize = file.getSize();

            try {
                // 파일 저장 경로 설정
                Path directoryPath = Paths.get("src/main/resources/static/backImage/pro/community");
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath); // 폴더가 없으면 생성
                }
                Path filePath = directoryPath.resolve(storedFileName);
                // 파일 저장
                Files.copy(file.getInputStream(), filePath);

                ProFileDTO fileDTO = new ProFileDTO();
                fileDTO.setProFileOriginName(originalFileName);
                fileDTO.setProFileName(directoryPath + "/" + storedFileName);
                fileDTO.setProFileSize(fileSize);
                fileDTO.setProPostNumber(proPostNumber);

                proFileMapper.insertProFile(fileDTO);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 게시글 상세보기 및 조회수
    @Override
    public ProCommunityDetailDTO selectProCommunityDetail(Long proPostNumber, Long proNumber) {
        ProCommunityDetailDTO pro = proCommunityMapper.selectProCommunityDetail(proPostNumber, proNumber);

        if(!proNumber.equals(pro.getProNumber())){
            proCommunityMapper.plusProView(proPostNumber);
        }
        return pro;
    }

    // 게시글 삭제하기
    @Override
    @Transactional
    public void deleteProCommunity(Long proPostNumber) {
        proFileMapper.deleteProFile(proPostNumber);
        proCommunityMapper.deleteProCommunity(proPostNumber);
    }

    // 게시글 수정하기
    @Override
    public void updateProCommunity(ProCommunityDTO pro, List<MultipartFile> files) {
        proCommunityMapper.updateProCommunity(pro);

        // 원래있던 파일 삭제 후 수정
        proFileMapper.deleteProFile(pro.getProPostNumber());
        saveProFile(pro.getProPostNumber(), files);
    }
}
