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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class parentInfoServiceImpl implements parentInfoService {
    private final ParentMapper parentMapper;
    private final infoMapper infoMapper;
    private final ParentFileMapper parentFileMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
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

        parentDTO.setParentNumber(parent.getParentNumber());
        parentDTO.setParentEmail(parent.getParentEmail());
        parentDTO.setParentPassword(parent.getParentPassword());
        parentDTO.setParentProfileImageUrl(parent.getParentProfileImageUrl());
        parentDTO.setParentReportCount(parent.getParentReportCount());
        log.info(parentDTO.getParentAddress());
        log.info(parentDTO.getParentName());
        parentMapper.updateInfo(ParentVO.toEntity(parentDTO));
    }

    @Override
    public String updateImg(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }

            String originalFileName = file.getOriginalFilename();
            String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFileName;
            Long fileSize = file.getSize();

            try {
                // 파일 저장 경로 설정
                Path directoryPath = Paths.get("src/main/resources/static/backImage/parent/prifile");
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath); // 폴더가 없으면 생성
                }
                Path filePath = directoryPath.resolve(storedFileName);
                // 파일 저장
                Files.copy(file.getInputStream(), filePath);

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String currentUserName = userDetails.getUsername();

                //      parent VO 찾아서 아이디 찾기
                ParentVO parent = parentMapper.selectOne(currentUserName);
                String parentPrifileImageUrl= directoryPath + "/" + storedFileName;

                parentFileMapper.updatePic(parentPrifileImageUrl,parent.getParentNumber());

                return "/backImage/parent/prifile/" + storedFileName;


            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public void updatePassword(String password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      parent VO 찾아서 아이디 찾기
        ParentVO parent = parentMapper.selectOne(currentUserName);

        infoMapper.updatePassword(parent.getParentNumber(),bCryptPasswordEncoder.encode(password));
    }
}
