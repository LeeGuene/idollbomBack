package com.example.idollbom.controller.board;

import com.example.idollbom.domain.dto.boarddto.CommunityListDTO;
import com.example.idollbom.domain.dto.recommend.PagedResponse;
import com.example.idollbom.service.boardservice.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class ParentcommunityRestController {

    private final CommunityService communityService;

    @GetMapping
    public ResponseEntity<PagedResponse<CommunityListDTO>> getBoardList(@RequestParam(defaultValue = "1") int pageNo,
                                                                        @RequestParam(defaultValue = "5") int pageSize,
                                                                        @RequestParam String searchType,
                                                                        @RequestParam String searchWord) {

        return ResponseEntity.ok(communityService.searchCommunityList(searchType, searchWord, pageNo, pageSize));
    }

}
