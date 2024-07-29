package com.example.idollbom.service.customserviceservice.question;

import com.example.idollbom.domain.dto.customservice.question.QuestionDTO;
import com.example.idollbom.domain.dto.customservice.question.QuestionListDTO;
import com.example.idollbom.domain.vo.QuestionVO;
import com.example.idollbom.mapper.customservicemapper.question.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;

    // 전체 문의하기 목록 조회하기 ( 페이징 처리 )
    @Override
    public List<QuestionListDTO> findQuestionAll(int pageNo, int pageSize) {

        int startRow = (pageNo - 1) * pageSize;
        int endRow = pageNo * pageSize;

        return questionMapper.selectQuestionAll(startRow, endRow);
    }

    // 전체 문의목록 개수 조회 서비스
    @Override
    public int countQuestion() {
        return questionMapper.countQuestion();
    }
    
    // 문의하기 추가
    @Override
    public void saveQuestion(QuestionDTO question) {
        questionMapper.insertQuestion(QuestionVO.toEntity(question));
    }
}
