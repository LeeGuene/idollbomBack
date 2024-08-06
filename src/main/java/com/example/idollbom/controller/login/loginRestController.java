package com.example.idollbom.controller.login;

import com.example.idollbom.service.loginservice.ParentService;
import com.example.idollbom.service.loginservice.ProService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
@RequiredArgsConstructor
@Slf4j
public class loginRestController {
    private final ProService proService;
    private final ParentService parentService;
    @GetMapping("/checkEmail")
    public ResponseEntity<String> checkEmail(@RequestParam(value = "email") String email) {
        log.info("Received email: {}", email);

        // ProService에서 이메일 검색
        String result = proService.selectEmail(email);
        if (result != null) {
            return ResponseEntity.ok(result);  // ProService에서 찾은 경우
        }

        // ParentService에서 이메일 검색
        result = parentService.selectEmail(email);
        if (result != null) {
            return ResponseEntity.ok(result);  // ParentService에서 찾은 경우
        }

        // 두 서비스 모두에서 찾지 못한 경우
        return ResponseEntity.ok("null");
    }

}
