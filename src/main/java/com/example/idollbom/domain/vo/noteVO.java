package com.example.idollbom.domain.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
public class noteVO {
    private Long parentNoteNumber;
    private String parentNoteContent;
    private LocalDateTime parentNoteSendTime;
    private String parentNoteAlarmCheck;
    private Long parentNumber;
    private Long proNumber;

    @Builder
    public noteVO(Long parentNoteNumber, String parentNoteContent, LocalDateTime parentNoteSendTime, String parentNoteAlarmCheck, Long parentNumber, Long proNumber) {
        this.parentNoteNumber = parentNoteNumber;
        this.parentNoteContent = parentNoteContent;
        this.parentNoteSendTime = parentNoteSendTime;
        this.parentNoteAlarmCheck = parentNoteAlarmCheck;
        this.parentNumber = parentNumber;
        this.proNumber = proNumber;
    }

}
