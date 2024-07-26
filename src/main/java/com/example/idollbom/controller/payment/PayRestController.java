package com.example.idollbom.controller.payment;

import com.example.idollbom.domain.dto.boarddto.ParentCommentDTO;
import com.example.idollbom.domain.dto.paymentdto.PayDTO;
import com.example.idollbom.service.myPageservice.parentservice.paymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pay/rest")
public class PayRestController {

    private final paymentService paymentService;

    // 결제하기 버틑을 눌렀을 때
    @PostMapping("/chargingOk")
    public ResponseEntity<?> payInsert(@RequestBody PayDTO payDTO) {
        paymentService.payInsert(payDTO);
        return ResponseEntity.ok().build();
    }

}
