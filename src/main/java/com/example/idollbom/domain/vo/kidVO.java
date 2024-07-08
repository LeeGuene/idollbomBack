package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class kidVO {
    private Long childNumber;
    private String childName;
    private String childAge;
    private String childGender;
    private String childSpecialIssues;
    private Long parentNumber;

    public static kidVO toEntity(kidDTO kidDTO){


        return kidVO.builder()
                .parentNumber(kidDTO.getParentNumber())
                .childName(kidDTO.getChildName())
                .childAge(kidDTO.getChildAge())
                .childGender(kidDTO.getChildGender())
                .childSpecialIssues(kidDTO.getChildSpecialIssues())
                .childNumber(kidDTO.getChildNumber())
                .build();

    }

}
