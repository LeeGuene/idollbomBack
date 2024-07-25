package com.example.idollbom.domain.dto.recommend;

import lombok.Data;

@Data
public class RecommendListDTO {

    String proProfileImageUrl;  // 전문가 프로필 이미지
    String proName;             // 전문가 이름
    double averageRating;       // 전문가에 대한 평균 별점
    int reviewCount;            // 전문가에 대한 리뷰 총 개수

}
