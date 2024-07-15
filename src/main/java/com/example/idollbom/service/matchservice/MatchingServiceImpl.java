package com.example.idollbom.service.matchservice;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import com.example.idollbom.mapper.matchmapper.MatchingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

    private final MatchingMapper matchingMapper;

    @Override
    public List<MatchingDTO> matchClass(String category, String categoryData, String selectedDate, String selectedTime) {
        return matchingMapper.matchClass(category, categoryData, selectedDate, selectedTime);
    }
}
