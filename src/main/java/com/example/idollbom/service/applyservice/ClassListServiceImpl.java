package com.example.idollbom.service.applyservice;

import com.example.idollbom.domain.dto.applydto.ClassListDTO;
import com.example.idollbom.mapper.applymapper.ClassListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassListServiceImpl implements ClassListService {
    private final ClassListMapper classListMapper;

    @Override
    public List<ClassListDTO> findAllClass(String category, int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        return classListMapper.findAllClass(category, startRow, endRow);
    }

    @Override
    public int classCount(String category) {
        return classListMapper.classCount(category);
    }

    @Override
    public List<ClassListDTO> searchClassList(String searchWord, String searchType, String category, int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        int endRow = page * pageSize;

        return classListMapper.searchClassList(searchWord, searchType, category, startRow, endRow);
    }

    @Override
    public int countClasses(String category, String searchType, String searchWord) {
        return classListMapper.countClasses(category, searchType, searchWord);
    }
}
