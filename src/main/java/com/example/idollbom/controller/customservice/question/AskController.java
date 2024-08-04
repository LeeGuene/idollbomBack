package com.example.idollbom.controller.customservice.question;

import com.example.idollbom.domain.dto.customservice.question.QuestionDTO;
import com.example.idollbom.domain.dto.customservice.question.QuestionListDTO;
import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.service.customserviceservice.question.QuestionService;
import com.example.idollbom.service.myPageservice.parentservice.noteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ask")
@RequiredArgsConstructor
@Slf4j
public class AskController {

    private final ParentMapper parentMapper;
    private final QuestionService questionService;
    private final noteService noteService;

    public void getRole(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {
            CustomUserDTO parent_info = ((CustomUserDTO) authentication.getPrincipal());
            String parentId = parent_info.getEmail();

            ParentVO parent = parentMapper.selectOne(parentId);
            log.info("부모 정보 : " + parent.toString());
            int count = noteService.countParentNoteList(parent.getParentNumber());
            log.info("count : " + count);
            model.addAttribute("count", count);
            model.addAttribute("role", parent.getRole());
            model.addAttribute("parentNumber", parent.getParentNumber());
        }
    }

    // 문의하기 페이지 불러오기
    @GetMapping("/list")
    public String ask(@RequestParam(value="pageNo", defaultValue = "1") int pageNo,
                      @RequestParam(value="pageSize", defaultValue = "3") int pageSize,
                      Model model) {

        getRole(model);

        int totalQuestions = questionService.countQuestion();
        int totalPages = (int) Math.ceil((double) totalQuestions / pageSize);
        List<QuestionListDTO> questionList = questionService.findQuestionAll(pageNo, pageSize);
        
        // 공개 / 비공개 글임을 구분하는 문의하기 pk를 저장할 리스트 변수
        List<Long> visibleList = new ArrayList<>();

        for(QuestionListDTO question : questionList) {
            if(question.getQuestionReadingCheck().equals("공개")){
                visibleList.add(question.getQuestionNumber()); // 공개인 것만 추가
            }
        }

        model.addAttribute("visibleList", visibleList);

        int pageGroupSize = 5;
        int startPage = ((pageNo - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        model.addAttribute("questionList", questionList);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/html/customerService/question/question";
    }

    @GetMapping("/write")
    public String goWriteForm(Model model) {

        getRole(model);

        model.addAttribute("question", new QuestionDTO());
        return "/html/customerService/question/inqueryBoardForm";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute QuestionDTO question) {

        log.info("View에서 넘어온 데이터들 : ");
        log.info("questionReadingCheck(열람가능 여부) : " + question.getQuestionReadingCheck());
//        log.info("questionNumber(문의 pk) : " + question.getQuestionNumber());
        log.info("parentNumber(부모 pk) : " + question.getParentNumber());
        log.info("questionTitle(문의 제목) : " + question.getQuestionTitle());
        log.info("questionContent(문의 내용) : " + question.getQuestionContent());

        // 문의하기 추가 쿼리문 실행
        questionService.saveQuestion(question);

        return "redirect:/ask/list";
    }
}
