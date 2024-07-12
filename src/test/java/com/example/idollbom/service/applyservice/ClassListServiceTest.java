package com.example.idollbom.service.applyservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ClassListServiceTest {

    @Autowired
    ClassListService classListService;

    @Test
    public void test() {
        log.info(classListService.findAllClass("등/하원", 1, 5).toString());
    }
}