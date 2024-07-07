package com.example.idollbom.service.loginservice;
import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.domain.vo.loginvo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentMapper parentMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(ParentDTO dto) {
        dto.setParentPassword(bCryptPasswordEncoder.encode(dto.getParentPassword()));
        ParentVO vo = ParentVO.toEntity(dto);

        parentMapper.insert(vo);
    }


}
