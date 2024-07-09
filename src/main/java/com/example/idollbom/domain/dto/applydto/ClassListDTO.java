package com.example.idollbom.domain.dto.applydto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class ClassListDTO {
    private String proProfileImageUrl;
    private String proName;
    private String proAddress;
    private String className;
    private String classContent;
    private Long classNumber;
    private Long proNumber;
}
