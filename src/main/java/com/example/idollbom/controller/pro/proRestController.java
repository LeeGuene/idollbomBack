package com.example.idollbom.controller.pro;

import com.example.idollbom.service.myPageservice.proservice.proUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/proRestController")
@RequiredArgsConstructor
@Slf4j
public class proRestController {
    private final proUpdateService proUpdateService;
    @PutMapping("/updatePassword")
    public void updatePassword(@RequestParam("password") String password){
        proUpdateService.proPasswordUpdate(password);
    }

    @PutMapping("/proUpdateImg")
    public void updateImg(@RequestParam("file") MultipartFile file){
        proUpdateService.proImgUpdate(file);
    }
}
