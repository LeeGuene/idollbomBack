package com.example.idollbom.domain.dto.prodto;

import lombok.Data;

// 아이찾기에 뿌려줄 데이터에 사용하는 DTO
// ( 추가될 수도 있어서 컬럼 추가 )
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
