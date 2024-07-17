package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.boarddto.CommunityDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@ToString
@NoArgsConstructor
public class CommunityVO {

    private int parentPostNumber;
    private String parentPostTitle;
    private String parentPostContent;
    private int parentPostViews;
    private LocalDateTime parentPostRegisterDate;
    private LocalDateTime parentPostUpdateDate;
    private int parentNumber;

    @Builder
    public CommunityVO(int parentPostNumber, String parentPostTitle, String parentPostContent, int parentPostViews, LocalDateTime parentPostRegisterDate, LocalDateTime parentPostUpdateDate, int parentNumber){
        this.parentPostNumber = parentPostNumber;
        this.parentPostTitle = parentPostTitle;
        this.parentPostContent = parentPostContent;
        this.parentPostViews = parentPostViews;
        this.parentPostRegisterDate = parentPostRegisterDate;
        this.parentPostUpdateDate = parentPostUpdateDate;
        this.parentNumber = parentNumber;
    }

    public static CommunityVO toEntity(CommunityDTO communityDTO){
        return CommunityVO.builder().parentPostNumber(communityDTO.getParentPostNumber())
                .parentPostTitle(communityDTO.getParentPostTitle())
                .parentPostContent(communityDTO.getParentPostContent())
                .parentPostViews(communityDTO.getParentPostViews())
                .parentPostRegisterDate(communityDTO.getParentPostRegisterDate())
                .parentPostUpdateDate(communityDTO.getParentPostUpdateDate())
                .parentNumber(communityDTO.getParentNumber())
                .build();

    }

}
