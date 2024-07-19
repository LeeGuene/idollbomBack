package com.example.idollbom.mapper.boardMapper;

import com.example.idollbom.mapper.boardmapper.CommunityMapper;
import com.example.idollbom.mapper.mainmapper.RecommendMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommunityMapperTest {

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private RecommendMapper recommendMapper;



}
