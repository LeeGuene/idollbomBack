package com.example.idollbom.domain.vo;

import com.example.idollbom.domain.dto.myPagedto.parentdto.NoteDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

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

    public static noteVO toEntity(NoteDTO note) {
        return noteVO.builder()
                .parentNoteNumber(note.getParentNoteNumber())
                .parentNoteContent(note.getParentNoteContent())
                .parentNoteSendTime(note.getParentNoteSendTime())
                .parentNoteAlarmCheck(note.getParentNoteAlarmCheck())
                .parentNumber(note.getParentNumber())
                .proNumber(note.getProNumber())
                .build();
    }

}
