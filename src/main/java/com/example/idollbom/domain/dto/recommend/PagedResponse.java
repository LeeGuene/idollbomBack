package com.example.idollbom.domain.dto.recommend;

import lombok.Data;

import java.util.List;

@Data
public class PagedResponse<T> {
    private List<T> content;     // 전문가를 추천하기 위한 전문가에 대한 정보 목록
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private int totalElements;
    private int startPage;
    private int endPage;

    public PagedResponse(List<T> content, int currentPage, int totalPages, int pageSize, int totalElements) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.totalElements = totalElements;

        this.startPage = Math.max(1, currentPage - 5);
        this.endPage = Math.min(totalPages, currentPage + 4);
    }

}
