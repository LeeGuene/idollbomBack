package com.example.idollbom.controller.payment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay/rest")
public class PayRestController {

    // 결제하기 버틑을 눌렀을 때
    @PostMapping("/chargingOk")
    public String chargingOk(@RequestBody String result) {
        System.out.println(result);
        return result + "ok";
    }
}
