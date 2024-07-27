package com.example.idollbom.mapper.customservicemapper.question;

import com.example.idollbom.domain.dto.customservice.question.QuestionDTO;
import com.example.idollbom.domain.dto.customservice.question.QuestionListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    // 전체 문의하기 목록 조회하기 ( 페이징 처리 )
    List<QuestionListDTO> selectQuestionAll(int startRow, int endRow);

    // 문의목록 총 개수 조회하기
    int countQuestion();

    // 문의하기 추가
    void insertQuestion(QuestionDTO question);
}

