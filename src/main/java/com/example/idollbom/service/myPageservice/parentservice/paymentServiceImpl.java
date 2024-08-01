package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.myPagedto.parentdto.paymentDTO;
import com.example.idollbom.domain.dto.paymentdto.PayDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.mapper.myPagemapper.parentmapper.paymentMapper;
import com.example.idollbom.mapper.proMapper.ProDetailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class paymentServiceImpl implements paymentService {

    private final ParentMapper parentMapper;
    private final paymentMapper paymentMapper;
    private final ProDetailMapper proDetailMapper;
    @Override
    public List<paymentDTO> paymentList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      parent VO 찾아서 아이디 찾기
        ParentVO parent = parentMapper.selectOne(currentUserName);
        List<paymentDTO> payment = paymentMapper.selectAll(parent.getParentNumber());
        for(int i=0; i<payment.size(); i++){
            payment.get(i).setProName(proDetailMapper.selectProDetail(payment.get(i).getProNumber()).getProName());
        }
        return payment;
    }

    // 트랜잭션 넣어줘야함 UPDATE문 필요
    @Override
    @Transactional
    public void payInsert(PayDTO payDTO) {
        System.out.println(payDTO.getReservationTimeNumber());

        // 결제내역 테이블 insert
        paymentMapper.payInsert(payDTO);
        // 결제완료된 시간 pk 가져와서 update
        paymentMapper.payStatus(payDTO.getReservationTimeNumber());
    }
}
