package com.example.idollbom.service.myPageservice.proservice;
import com.example.idollbom.domain.dto.logindto.ProDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.mapper.loginmapper.ProMapper;
import com.example.idollbom.mapper.proMapper.ProDetailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

import static com.example.idollbom.domain.vo.ProVO.toEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class proUpdateServiceImpl implements proUpdateService {
    private final ProMapper proMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ProDetailMapper proDetailMapper;
    @Override
    public void proPasswordUpdate(String proPassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      pro VO 찾아서 아이디 찾기
        ProVO pro = proMapper.selectPro(currentUserName);
        String password = bCryptPasswordEncoder.encode(proPassword);
        proMapper.updatePassword(password,pro.getProNumber());
    }

    @Override
    public void proImgUpdate(MultipartFile file) {
        String imgName = file.getOriginalFilename();

        if (imgName == null || imgName.trim().isEmpty()) {
            System.out.println("파일 이름이 유효하지 않습니다.");
            return;
        }

        // 파일 이름에서 경로 구분 기호를 안전하게 처리
        imgName = imgName.replaceAll("[/:*?\"<>|]", "_");

        // 파일 이름 유효성 검사
        try {
            Paths.get(imgName); // 파일 이름이 유효한지 검사
        } catch (InvalidPathException e) {
            System.out.println("유효하지 않은 파일 이름입니다: " + imgName);
            return;
        }

        System.out.println(imgName);

        try {
            Path directoryPath = Paths.get("src/main/resources/static/backImage/parent/profile");
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            Path filePath = directoryPath.resolve(imgName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // url 지정
            String imageUrl = "/backImage/parent/profile" + imgName;

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String currentUserName = userDetails.getUsername();

//      pro VO 찾아서 아이디 찾기
            ProVO pro = proMapper.selectPro(currentUserName);

            proDetailMapper.updateImg(pro.getProNumber(),imageUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProDTO proDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

        //      pro VO 찾아서 아이디 찾기
        ProVO pro = proMapper.selectPro(currentUserName);

        proDTO.setProNumber(pro.getProNumber());

        proDetailMapper.update(toEntity(proDTO));
    }
}

