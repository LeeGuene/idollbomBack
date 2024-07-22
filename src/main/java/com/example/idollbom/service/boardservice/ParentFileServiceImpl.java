package com.example.idollbom.service.boardservice;

import com.example.idollbom.domain.vo.ParentFileVO;
import com.example.idollbom.mapper.boardmapper.ParentFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentFileServiceImpl implements ParentFileService {

    private final ParentFileMapper parentFileMapper;

}
