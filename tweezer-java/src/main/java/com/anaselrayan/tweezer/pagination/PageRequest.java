package com.anaselrayan.tweezer.pagination;

import lombok.Data;

import java.util.Objects;

@Data
public class PageRequest {
    Integer page;
    Integer size;
    Boolean asc;
    String sortCol;
    private final int DEFAULT_PAGE_SIZE = 10;

    public PageRequest(Integer page, Integer size) {
        this.size = Objects.requireNonNullElse(size, DEFAULT_PAGE_SIZE);
        this.page = page;
    }

    public PageRequest(Integer page, Integer size, Boolean ASC, String sortCol) {
        this.page = page;
        this.size = size;
        this.asc = ASC;
        this.sortCol = sortCol;
    }
}
