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
    private Long parentNumber;

    @Builder
    public CommunityVO(int parentPostNumber, String parentPostTitle, String parentPostContent, int parentPostViews, LocalDateTime parentPostRegisterDate, LocalDateTime parentPostUpdateDate, Long parentNumber){
        this.parentPostNumber = parentPostNumber;
        this.parentPostTitle = parentPostTitle;
        this.parentPostContent = parentPostContent;
        this.parentPostViews = parentPostViews;
        this.parentPostRegisterDate = parentPostRegisterDate;
        this.parentPostUpdateDate = parentPostUpdateDate;
        this.parentNumber = parentNumber;
    }
}
