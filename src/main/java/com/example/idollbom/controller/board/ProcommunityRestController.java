package com.example.idollbom.controller.board;

import com.example.idollbom.domain.dto.boarddto.ProCommunityListDTO;
import com.example.idollbom.domain.dto.recommend.PagedResponse;
import com.example.idollbom.service.boardservice.ProCommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class ProcommunityRestController {

    private final ProCommunityService proCommunityService;

    @GetMapping("proList")
    public ResponseEntity<PagedResponse<ProCommunityListDTO>> getProCommunityList(@RequestParam(defaultValue = "1") int pageNo,
                                                                                  @RequestParam(defaultValue = "5") int pageSize,
                                                                                  @RequestParam String searchType,
                                                                                  @RequestParam String searchWord) {

        return ResponseEntity.ok(proCommunityService.searchProCommunityList(searchType, searchWord, pageNo, pageSize));
    }
}
