package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.askVO;
import com.example.idollbom.mapper.myPagemapper.parentmapper.AskMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class askServiceImpl implements askService {

    private final AskMapper askMapper;
    @Override
    public List<askVO> selectAskList() {
        return askMapper.selectAll();
    }
}
