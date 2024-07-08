package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.noteVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface noteService {
    List<noteVO> selectAllMyNote();
}
