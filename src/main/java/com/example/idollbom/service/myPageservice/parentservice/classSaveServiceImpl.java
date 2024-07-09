package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.classSaveVO;
import com.example.idollbom.mapper.myPagemapper.parentmapper.classSaveMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class classSaveServiceImpl implements classSaveService {

    private final classSaveMapper classSaveMapper;
    @Override
    public List<classSaveVO> selectClassList() {
        return classSaveMapper.selectAll();
    }

    // 수업 찜 목록 추가
    @Override
    public int saveClass(Long classNumber, Long parentNumber) {
        return classSaveMapper.insertClass(classNumber, parentNumber);
    }
}
