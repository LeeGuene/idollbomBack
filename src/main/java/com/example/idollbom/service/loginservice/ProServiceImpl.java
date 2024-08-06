package com.example.idollbom.service.loginservice;

import com.example.idollbom.domain.dto.logindto.ProDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.mapper.loginmapper.ProMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
@RequiredArgsConstructor
public class ProServiceImpl implements ProService {

    private final ProMapper proMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ParentMapper parentMapper;

    @Override
    public ProVO selectPro(String proId) {
        return proMapper.selectPro(proId);
    }

    // 전문가 회원가입 서비스
    @Override
    public void savePro(ProDTO proDTO, MultipartFile file, MultipartFile proImg) {
        // 비밀번호 암호화
        proDTO.setProPassword(bCryptPasswordEncoder.encode(proDTO.getProPassword()));
        proDTO.setProProfileImageUrl(proInsertImg(proImg));
        proDTO.setProFile(proInsertFile(file));

        ProVO pro = ProVO.toEntity(proDTO);

        proMapper.insert(pro);
    }

    @Override
    public String proInsertImg(MultipartFile img) {
        String imgName = img.getOriginalFilename();

        if (imgName == null || imgName.trim().isEmpty()) {
            System.out.println("파일 이름이 유효하지 않습니다.");
            return imgName;
        }

        // 파일 이름에서 경로 구분 기호를 안전하게 처리
        imgName = imgName.replaceAll("[/:*?\"<>|]", "_");

        // 파일 이름 유효성 검사
        try {
            Paths.get(imgName); // 파일 이름이 유효한지 검사
        } catch (InvalidPathException e) {
            System.out.println("유효하지 않은 파일 이름입니다: " + imgName);
            return imgName;
        }

        System.out.println(imgName);

        String imageUrl = null;
        try {
            Path directoryPath = Paths.get("src/main/resources/static/backImage/pro/profile");
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            Path filePath = directoryPath.resolve(imgName);
            Files.copy(img.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // url 지정
            imageUrl = "/backImage/pro/profile/" + imgName;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageUrl;
    }
    @Override
    public String proInsertFile(MultipartFile file) {
        String imgName = file.getOriginalFilename();

        if (imgName == null || imgName.trim().isEmpty()) {
            System.out.println("파일 이름이 유효하지 않습니다.");
            return imgName;
        }

        // 파일 이름에서 경로 구분 기호를 안전하게 처리
        imgName = imgName.replaceAll("[/:*?\"<>|]", "_");

        // 파일 이름 유효성 검사
        try {
            Paths.get(imgName); // 파일 이름이 유효한지 검사
        } catch (InvalidPathException e) {
            System.out.println("유효하지 않은 파일 이름입니다: " + imgName);
            return imgName;
        }

        System.out.println(imgName);

        String imageUrl = null;
        try {
            Path directoryPath = Paths.get("src/main/resources/static/backImage/pro/file");
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            Path filePath = directoryPath.resolve(imgName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // url 지정
            imageUrl = "/backImage/pro/file/" + imgName;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageUrl;
    }

    @Override
    public String selectEmail(String proEmail) {

        return proMapper.selectEmail(proEmail);
    }
}