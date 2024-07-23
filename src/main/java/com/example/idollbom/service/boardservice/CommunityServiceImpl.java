package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.dto.boarddto.CommunityDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityDetailDTO;
import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import com.example.idollbom.domain.dto.boarddto.ParentFileDTO;
import com.example.idollbom.mapper.boardmapper.CommunityMapper;
import com.example.idollbom.mapper.boardmapper.ParentFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityMapper communityMapper;
    private final ParentFileMapper parentFileMapper;

    // 페이징 처리
    @Override
    public List<CommunityListDTO> getCommunityList(int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        return communityMapper.selectAll(startRow, endRow);
    }

    // 현재 게시글 갯수
    @Override
    public int getCommunityListCount() {
        return communityMapper.countCommunity();
    }

    // 자유게시판 등록 구현
    @Override
    @Transactional
    public void saveCommunity(CommunityDTO community, List<MultipartFile> files, Long parentNumber) {
        int parentPostNumber = communityMapper.getSeq();
        community.setParentPostNumber(parentPostNumber);
        community.setParentNumber(parentNumber);

        communityMapper.saveCommunity(community);
        saveFile(community.getParentPostNumber(), files);
    }

    // 여러 개의 청부파일을 올리기 위한 메소드
    @Override
    public void saveFile(int parentPostNumber, List<MultipartFile> files) {
        for (MultipartFile file : files) {
            // 방어코드
            if (file.isEmpty()) continue; // 파일이 비어있으면 건너뜀

            String originalFileName = file.getOriginalFilename();
            String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;
            Long fileSize = file.getSize();

            try {
                // 파일 저장 경로 설정
                Path directoryPath = Paths.get("src/main/resources/static/backImage/parent/community");
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath); // 폴더가 없으면 생성
                }
                Path filePath = directoryPath.resolve(storedFileName);
                // 파일 저장
                Files.copy(file.getInputStream(), filePath);

                ParentFileDTO fileDTO = new ParentFileDTO();
                fileDTO.setParentFileName(directoryPath + "/" + storedFileName);
                fileDTO.setParentFileSize(fileSize);
                fileDTO.setParentPostNumber((long) parentPostNumber);

                parentFileMapper.insertFile(fileDTO);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 게시글 상세보기 및 조회수
    @Override
    public CommunityDetailDTO selectCommunityDetail(Long parentPostNumber) {
        return communityMapper.selectCommunityDetail(parentPostNumber);
    }

    // 게시글 삭제하기
    @Override
    @Transactional
    public void deleteCommunity(Long parentPostNumber) {
        // 첨부파일도 같이 삭제해주자.
        parentFileMapper.deleteFile(parentPostNumber);
        communityMapper.deleteCommunity(parentPostNumber);
    }

    // 게시글 수정하기
    @Override
    public void updateCommunity(CommunityDTO community) {
        communityMapper.updateCommunity(community);
    }
}


