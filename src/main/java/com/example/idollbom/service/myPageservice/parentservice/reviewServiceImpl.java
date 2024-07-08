package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.reviewVO;
import com.example.idollbom.mapper.myPagemapper.parentmapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class reviewServiceImpl implements reviewService {

    private final ReviewMapper reviewMapper;
    @Override
    public List<reviewVO> selectRiviewList() {
        return reviewMapper.selectAll();
    }
}
