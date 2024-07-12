package com.example.idollbom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pro")
@RequiredArgsConstructor
@Slf4j
public class RegisterFormController {

    @GetMapping()
    public String registerFromController(Model model) {


        return "/html/pro/registerForm";
    }
}
