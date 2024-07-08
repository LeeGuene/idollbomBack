package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.vo.myPostVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface myPostService {
    public List<myPostVO> selectPostList();
}
