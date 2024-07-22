package com.example.idollbom.service.myPageservice.proservice;

import com.example.idollbom.domain.dto.prodto.proReportDTO;
import com.example.idollbom.domain.vo.ProPostVO;
import com.example.idollbom.domain.vo.classVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface classService {
//  내수업 전체 보기
    List<classVO> selectMyClass(Long proNumber);

//  내 신고목록 전체보기
    List<proReportDTO> selectReport(Long proNumber);

//  내 게시글 전체보기
    List<ProPostVO> selectPost(Long porNumber);
}

