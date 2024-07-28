package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.boardmapper.ParentFileMapper;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.mapper.myPagemapper.parentmapper.infoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class parentInfoServiceImpl implements parentInfoService {
    private final ParentMapper parentMapper;
    private final infoMapper infoMapper;
    private final ParentFileMapper parentFileMapper;
    @Override
    public ParentVO selectParentInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      parent VO 찾아서 아이디 찾기
        ParentVO parent = parentMapper.selectOne(currentUserName);

        return infoMapper.selectMyInfo(parent.getParentNumber());
    }

    @Override
    public void update(ParentDTO parentDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      parent VO 찾아서 아이디 찾기
        ParentVO parent = parentMapper.selectOne(currentUserName);

        parentDTO.setParentEmail(parent.getParentEmail());
        parentDTO.setParentReportCount(parent.getParentReportCount());
        parentMapper.updateInfo(ParentVO.toEntity(parentDTO));


    }

    @Override
    public void updateImg(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }
        String originalFileName = file.getOriginalFilename();
        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;

        try {
            // 파일 저장 경로 설정
            String uploadDir = "/upload";
            Path directoryPath = Paths.get(uploadDir);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath); // 폴더가 없으면 생성
            }
            Path filePath = directoryPath.resolve(storedFileName);

            // 파일 저장
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // 데이터베이스에 파일 경로 저장
            String fileUrl = uploadDir + "/" + storedFileName;

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String currentUserName = userDetails.getUsername();

            // parent VO 찾아서 아이디 찾기
            ParentVO parent = parentMapper.selectOne(currentUserName);


            parentFileMapper.updatePic(fileUrl,parent.getParentNumber());

        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }

}
