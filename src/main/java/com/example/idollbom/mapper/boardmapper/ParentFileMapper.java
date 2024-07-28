package com.example.idollbom.mapper.boardmapper;

import com.example.idollbom.domain.dto.boarddto.ParentFileDTO;
import com.example.idollbom.domain.vo.ParentFileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Mapper
public interface ParentFileMapper {
    // 첨부파일 insert
    void insertFile(ParentFileDTO dto);

    // 첨부파일 삭제
    void deleteFile(Long parentPostNumber);

    // 첨부파일 가져오기
    List<ParentFileDTO> selectFileList(Long parentPostNumber);

    // 첨부파일 다운로드
    ParentFileDTO getFileById(Long parentFileNumber);

    // 부모사진 update
    void updatePic(String img, Long parentNumber);
}
