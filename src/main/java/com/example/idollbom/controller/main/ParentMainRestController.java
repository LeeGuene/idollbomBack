package com.example.idollbom.controller.main;

import com.example.idollbom.domain.dto.recommend.PagedResponse;
import com.example.idollbom.domain.dto.recommend.RecommendListDTO;
import com.example.idollbom.service.recommend.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/recommend")
public class ParentMainRestController {

    private final RecommendService recommendService;

    // 전문가 추천은 리뷰가 달려있는 사람만 추천.
    @GetMapping
    public ResponseEntity<PagedResponse<RecommendListDTO>> getBoardList(@RequestParam(defaultValue = "1") int page,
                                                                        @RequestParam(defaultValue = "3") int size
                                                                        ) {
        return ResponseEntity.ok(recommendService.getRecommendList(page, size));
    }

}
