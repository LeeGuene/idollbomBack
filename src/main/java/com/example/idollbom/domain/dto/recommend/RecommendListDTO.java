package com.example.idollbom.domain.dto.recommend;

import lombok.Data;

@Data
public class RecommendListDTO {

    String proProfileImageUrl;
    String proName;
    double averageRating;
    int reviewCount;

}
