package com.example.idollbom.mapper.applymapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ClassReviewMapperTest {

    @Autowired
    private ClassReviewMapper classReviewMapper;

    @Test
    public void test(){
        log.info(classReviewMapper.selectOneAllReview(6L, 16L).toString());
    }
}