package com.example.idollbom.service.matchservice;

import com.example.idollbom.domain.dto.matchdto.MatchingDTO;
import com.example.idollbom.mapper.matchmapper.MatchingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

    private final MatchingMapper matchingMapper;

    @Override
    public MatchingDTO matchClass() {
        return matchingMapper.matchClass();
    }
}
