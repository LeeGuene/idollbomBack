package com.example.idollbom.service.proService;

import com.example.idollbom.domain.dto.prodto.ClassDTO;
import com.example.idollbom.domain.dto.prodto.ClassImgDTO;
import com.example.idollbom.domain.dto.prodto.ReservationDateDTO;
import com.example.idollbom.domain.dto.prodto.ReservationTimeDTO;
import com.example.idollbom.mapper.proMapper.RegisterFormMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterFormServiceImpl implements RegisterFormService {

    private final RegisterFormMapper registerFormMapper;

    @Override
    @Transactional
    public void registerClass(ClassDTO classDTO, ReservationDateDTO reservationDateDTO, ReservationTimeDTO resTimeDTO, MultipartFile imageFileUrl) {
        System.out.println(classDTO);
        registerFormMapper.classInsert(classDTO);
        // 이미지 테이블에 들어가야하는 코드 필요
        // 날짜 테이블 삽입
        // 현재 class pk를 받아옴
        Long classNumber = registerFormMapper.currentSeq();
        saveFile(classNumber, imageFileUrl);
        reservationDateDTO.setClassNumber(classNumber);
        System.out.println(reservationDateDTO);
        registerFormMapper.classDateInsert(reservationDateDTO);

        // 현재 reservationNumber를 받아옴
        Long reservationNumber = registerFormMapper.currentSeq();
        resTimeDTO.setReservationDateNumber(reservationNumber);
        System.out.println(resTimeDTO);
        registerFormMapper.classTimeInsert(resTimeDTO);
    }

    @Override
    public void saveFile(Long classNumber, MultipartFile file) {
        String imgName = file.getOriginalFilename();
        String imgUrl = UUID.randomUUID().toString().replaceAll("-", "") + "_" + imgName;

        System.out.println(imgUrl);

        try {
            // 수업 썸네일 저장 경로
            Path directoryPath = Paths.get("src/main/resources/static/backImage/class/");
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath); // 폴더가 없으면 생성
            }
            // 파일 저장
            Path filePath = directoryPath.resolve(imgUrl);
            Files.copy(file.getInputStream(), filePath);

            ClassImgDTO fileDTO = new ClassImgDTO();
            fileDTO.setClassNumber(classNumber);
            fileDTO.setImageFileUrl(directoryPath + "/" + imgUrl);

            registerFormMapper.imageInsert(fileDTO); // 파일 정보 저장

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
