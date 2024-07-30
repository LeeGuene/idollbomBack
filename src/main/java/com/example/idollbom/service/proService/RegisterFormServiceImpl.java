package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.prodto.ClassDTO;
import com.example.idollbom.domain.dto.prodto.ClassImgDTO;
import com.example.idollbom.domain.dto.prodto.ReservationDateDTO;
import com.example.idollbom.domain.dto.prodto.ReservationTimeDTO;
import com.example.idollbom.domain.vo.ProVO;
import com.example.idollbom.mapper.loginmapper.ProMapper;
import com.example.idollbom.mapper.proMapper.RegisterFormMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterFormServiceImpl implements RegisterFormService {

    private final RegisterFormMapper registerFormMapper;
    private final ProMapper proMapper;

    @Override
    @Transactional
    public void registerClass(ClassDTO classDTO,
                              ReservationDateDTO reservationDateDTO,
                              MultipartFile imageFileUrl,
                              List<LocalDateTime> times) {

        // 현재 로그인한 전문가 pk 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDTO p = ((CustomUserDTO) authentication.getPrincipal());
        String proId = p.getEmail();

        ProVO pro = proMapper.selectPro(proId);
        System.out.println(pro.getProNumber());

        System.out.println(classDTO);
        classDTO.setProNumber(pro.getProNumber());
        registerFormMapper.classInsert(classDTO);

        // 이미지 테이블에 들어가야하는 코드 필요
        // 날짜 테이블 삽입
        // 현재 class pk를 받아옴
        Long classNumber = registerFormMapper.currentSeq();
        saveFile(classNumber, imageFileUrl);
        reservationDateDTO.setClassNumber(classNumber);
        System.out.println(reservationDateDTO);
        registerFormMapper.classDateInsert(reservationDateDTO);

        Long reservationNumber = registerFormMapper.currentSeq();
        for(LocalDateTime time : times){
            ReservationTimeDTO timeDTO = new ReservationTimeDTO();
            timeDTO.setReservationDateNumber(reservationNumber);
            timeDTO.setReservationTime(time);
            registerFormMapper.classTimeInsert(timeDTO);
        }
    }

    @Override
    public void saveFile(Long classNumber, MultipartFile file) {
//        String imgName = file.getOriginalFilename();
//        String imgUrl = UUID.randomUUID().toString().replaceAll("-", "") + "_" + imgName;
//
//        System.out.println(imgUrl);
//
//        try {
//            // 수업 썸네일 저장 경로
//            Path directoryPath = Paths.get("src/main/resources/static/backImage/class/");
//            if (!Files.exists(directoryPath)) {
//                Files.createDirectories(directoryPath); // 폴더가 없으면 생성
//            }
//
//            // 파일 저장
//            Path filePath = directoryPath.resolve(imgUrl);
//            Files.copy(file.getInputStream(), filePath);
//
//            // 이미지 URL은 상대 경로로 설정
//            String imageUrl = "/backImage/class/" + imgUrl;
//
//
//            ClassImgDTO fileDTO = new ClassImgDTO();
//            fileDTO.setClassNumber(classNumber);
//            fileDTO.setImageFileUrl(imageUrl);
//
//            registerFormMapper.imageInsert(fileDTO); // 파일 정보 저장
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
            Path directoryPath = Paths.get("src/main/resources/static/backImage/class/");
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            Path filePath = directoryPath.resolve(imgName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String imageUrl = "/backImage/class/" + imgName;

            ClassImgDTO fileDTO = new ClassImgDTO();
            fileDTO.setClassNumber(classNumber);
            fileDTO.setImageFileUrl(imageUrl);

            registerFormMapper.imageInsert(fileDTO);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
