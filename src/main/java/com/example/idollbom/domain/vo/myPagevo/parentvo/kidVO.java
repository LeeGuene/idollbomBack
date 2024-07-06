package com.example.idollbom.domain.vo.myPagevo.parentvo;

import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.domain.dto.myPagedto.parentdto.kidDTO;
import com.example.idollbom.domain.vo.loginvo.ParentVO;
import lombok.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class kidVO {
    private String childNumber;
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
                .build();

    }

}
