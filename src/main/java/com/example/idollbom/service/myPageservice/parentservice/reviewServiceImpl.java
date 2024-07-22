package com.example.idollbom.service.myPageservice.parentservice;

import com.example.idollbom.domain.dto.parentdto.ReviewDTO;
import com.example.idollbom.domain.vo.ParentVO;
import com.example.idollbom.domain.vo.reviewVO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.mapper.myPagemapper.parentmapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class reviewServiceImpl implements reviewService {

    private final ReviewMapper reviewMapper;
    private final ParentMapper parentMapper;

//  리뷰List 보기
    @Override
    public List<reviewVO> selectRiviewList() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      parent VO 찾아서 아이디 찾기
        ParentVO parent = parentMapper.selectOne(currentUserName);
        return reviewMapper.selectAll(parent.getParentNumber());
    }

//  리뷰 적기
    @Override
    public void insertReview(ReviewDTO reviewDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUserName = userDetails.getUsername();

//      parent VO 찾아서 아이디 찾기
        ParentVO parent = parentMapper.selectOne(currentUserName);

        log.info("아이디",parent.getParentNumber());
        reviewDTO.setParentNumber(parent.getParentNumber());
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate currentDate = currentDateTime.toLocalDate();
        reviewDTO.setReviewRegisterDate(currentDate);
        reviewDTO.setReviewUpdateDate(currentDate);

        reviewVO review = reviewVO.toEntity(reviewDTO);
        reviewMapper.insertReview(review);

    }
}
