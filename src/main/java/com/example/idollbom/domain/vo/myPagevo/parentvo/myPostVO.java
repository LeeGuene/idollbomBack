package com.example.idollbom.domain.vo.myPagevo.parentvo;

import lombok.*;

import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class myPostVO {
    private Long parentPostNumber;
    private String parentPostTitle;
    private String parentPostContent;
    private Long parentPostViews;
    private Date parentPostRegisterDate;
    private Date parentPostUpdateDate;
    private Long parentNumber;
}
