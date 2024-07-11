package com.example.idollbom.domain.dto.matchdto;

import lombok.Data;

@Data
public class MatchingDTO {
    private Long proNumber;
    private String proProfileImageUrl;
    private String proName;
    private String proAddress;
    private Long classNumber;
    private String className;
    private String classCategoryBig;
    private String classContent;
    private String classRegisterDate;
    private Long reviewCount;
}
