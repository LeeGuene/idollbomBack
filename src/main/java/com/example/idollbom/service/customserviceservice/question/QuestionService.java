package com.example.idollbom.service.customserviceservice.question;

import com.example.idollbom.domain.dto.customservice.question.QuestionDTO;
import com.example.idollbom.domain.dto.customservice.question.QuestionListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    // 전체 문의하기 목록 조회하기 ( 페이징 처리 )
    List<QuestionListDTO> findQuestionAll(int pageNo, int pageSize);

    // 전체 문의목록 개수 조회하기 서비스
    int countQuestion();

    // 문의하기 추가
    void saveQuestion(QuestionDTO question);
}
