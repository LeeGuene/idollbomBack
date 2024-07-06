package com.example.idollbom.controller.login;

import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.service.loginservice.ParentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentControllerTest {
    @Autowired
    ParentService parentService;

    @Test
    public void test(){
        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setParentPassword("j");
        parentDTO.setParentEmail("m");
        parentDTO.setParentAddress("d");
        parentDTO.setParentNickname("asdljs");
        parentDTO.setParentPhoneNumber("23423");
        parentDTO.setParentName("d");
        parentDTO.setParentProfileImageUrl("d");
        parentDTO.setParentReportCount("0");
        parentService.save(parentDTO);
    }
}