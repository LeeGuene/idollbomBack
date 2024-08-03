package com.example.idollbom.controller.board;

import com.example.idollbom.domain.dto.boarddto.ParentCommentDTO;
import com.example.idollbom.domain.dto.boarddto.ProCommentDTO;
import com.example.idollbom.service.boardservice.ProCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proComments")
@RequiredArgsConstructor
public class ProCommentRestController {

    private final ProCommentService proCommentService;

    // 댓글 조회 (특정 게시글의 모든 댓글 조회하기)
    @GetMapping("/{proPostNumber}")
    public ResponseEntity<?> getProComments(@PathVariable Long proPostNumber) {
        return ResponseEntity.ok(proCommentService.selectCommentByPro(proPostNumber));
    }

    // 댓글 추가
    @PostMapping
    public ResponseEntity<?> addProComment(@RequestBody ProCommentDTO commentDTO) {
        proCommentService.insertProComment(commentDTO);
        return ResponseEntity.ok().build();
    }

    // 댓글 삭제
    @DeleteMapping("/{proCommentNumber}")
    public ResponseEntity<?> deleteProComment(@PathVariable Long proCommentNumber) {
        proCommentService.deleteProComment(proCommentNumber);
        return ResponseEntity.ok().build();
    }


    // 댓글 수정
    @PutMapping("/{proCommentNumber}")
    public ResponseEntity<?> updateProComment(@PathVariable Long proCommentNumber, @RequestBody ProCommentDTO commentDTO) {
        commentDTO.setProCommentNumber(proCommentNumber);
        proCommentService.updateProComment(commentDTO);
        return ResponseEntity.ok().build();
    }
}
