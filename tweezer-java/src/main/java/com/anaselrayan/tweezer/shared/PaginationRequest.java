package com.anaselrayan.tweezer.shared;

public record PaginationRequest(
    int pageNumber,
    int pageSize,
    SortRequest sortRequest
) {}
