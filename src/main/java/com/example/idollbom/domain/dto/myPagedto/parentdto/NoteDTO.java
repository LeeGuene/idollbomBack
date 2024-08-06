package com.example.idollbom.domain.dto.myPagedto.parentdto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class NoteDTO {
    private Long parentNoteNumber;
    private String parentNoteContent;
    private LocalDateTime parentNoteSendTime;
    private String parentNoteAlarmCheck;
    private Long parentNumber;
    private Long proNumber;

}
