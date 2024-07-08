package com.example.idollbom.domain.vo;

import lombok.*;

@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class imgVO {
    private Long imageNumber;
    private String imageFileUrl;
    private Long classNumber;
}
