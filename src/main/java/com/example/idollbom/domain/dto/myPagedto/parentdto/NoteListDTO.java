package com.example.idollbom.domain.dto.myPagedto.parentdto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteListDTO {

    private Long parentNoteNumber;
    private String parentName;
    private String parentNoteContent;
    private LocalDateTime parentNoteSendTime;

}
