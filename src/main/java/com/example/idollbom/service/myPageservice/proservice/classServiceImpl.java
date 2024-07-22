package com.example.idollbom.service.myPageservice.proservice;

import com.example.idollbom.domain.dto.prodto.proReportDTO;
import com.example.idollbom.domain.vo.ProPostVO;
import com.example.idollbom.domain.vo.classVO;
import com.example.idollbom.mapper.proMapper.ProDetailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class classServiceImpl implements classService {

    private final ProDetailMapper proDetailMapper;
    @Override
    public List<classVO> selectMyClass(Long proNumber) {
        return proDetailMapper.selectMyClass(proNumber);
    }

    @Override
    public List<proReportDTO> selectReport(Long proNumber) {
        return proDetailMapper.selectProReport(proNumber);
    }

    @Override
    public List<ProPostVO> selectPost(Long porNumber) {
        return null;
    }
}
