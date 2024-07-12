package com.example.idollbom.mapper.proMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProDetailMapperTest {

    @Autowired
    private ProDetailMapper proDetailMapper;

    @Test
    void test(){
        log.info(proDetailMapper.selectProDetail(4L).toString());
    }
}