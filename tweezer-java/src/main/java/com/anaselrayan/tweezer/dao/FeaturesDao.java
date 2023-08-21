package com.anaselrayan.tweezer.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeaturesDao {
    private final JdbcTemplate jdbcTemplate;
    private final String PAGINATION_SQL = " OFFSET 0 FETCH NEXT 10 ROWS ONLY";

    public int getRowsCount(String query, Object...args) {
        query = query.substring(query.indexOf("FROM"));
        return jdbcTemplate.queryForObject("SELECT COUNT(*) " + query, Integer.class, args);
    }
}
