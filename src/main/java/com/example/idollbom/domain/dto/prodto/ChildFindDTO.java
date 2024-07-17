package com.example.idollbom.domain.dto.prodto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ChildFindDTO {

    private String parentName;
    private Long parentNumber;
    private String parentEmail;
    private String className;
    private String classContent;
    private String classCategoryBig;
    private String classCategorySmall;

}
