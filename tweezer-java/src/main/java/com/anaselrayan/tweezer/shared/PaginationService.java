package com.anaselrayan.tweezer.shared;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PaginationService {
    public static Pageable getPageable(PaginationRequest pr) {
        if (null == pr.sortRequest())
            return PageRequest.of(pr.pageNumber(), pr.pageSize());
        else
            return PageRequest.of(pr.pageNumber(), pr.pageSize(),
                    pr.sortRequest().direction(),
                    pr.sortRequest().sortCol());
    }
}
