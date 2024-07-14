package com.example.idollbom.service.matchservice;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchingService {
    // 매칭 정보를 가져오는 select
    List<MatchingDTO> matchClass(String category, String categoryData, String selectedDate, String selectedTime);
}
