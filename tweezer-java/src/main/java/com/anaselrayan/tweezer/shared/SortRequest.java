package com.anaselrayan.tweezer.shared;

import org.springframework.data.domain.Sort;

public record SortRequest(Sort.Direction direction,
                             String sortCol) {}
