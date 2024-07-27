package com.example.idollbom.controller.apply;

import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import com.example.idollbom.domain.dto.recommend.PagedResponse;
import com.example.idollbom.service.applyservice.ClassListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restList")
public class ClassListRestController {

    private final ClassListService classListService;

    @GetMapping
    public ResponseEntity<PagedResponse<ClassListDTO>> getBoardList(@RequestParam(defaultValue = "1") int pageNo,
                                                                    @RequestParam(defaultValue = "5") int pageSize,
                                                                    @RequestParam(value = "category", defaultValue = "등/하원") String category,
                                                                    @RequestParam String searchType,
                                                                    @RequestParam String searchWord) {
        System.out.println(category);

        return ResponseEntity.ok(classListService.searchClassList(searchType, searchWord, category, pageNo, pageSize));
    }

}
