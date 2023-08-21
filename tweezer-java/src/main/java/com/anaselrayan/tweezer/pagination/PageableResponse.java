package com.anaselrayan.tweezer.pagination;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class PageableResponse<T> {
    List<T> content;
    int page;
    int size;
    int totalPages;
    int totalElements;

    public PageableResponse(List<T> content, int totalElements, PageRequest pageRequest) {
        this.content = content;
        this.totalElements = totalElements;
        this.page = pageRequest.getPage();
        this.size = pageRequest.getSize();
        this.totalPages = totalElements / size;
    }
}
