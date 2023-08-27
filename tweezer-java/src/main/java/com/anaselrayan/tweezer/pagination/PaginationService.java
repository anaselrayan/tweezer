package com.anaselrayan.tweezer.pagination;

public class PaginationService {
    public static String addSortAndPaginationQuery(String query, PageRequest pr) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(query);
        if (pr.getSortCol() != null) {
            String dir = null == pr.asc || pr.asc ? "ASC" : "DESC";
            strBuilder.append(" ORDER BY ").append(pr.sortCol).append(" ").append(dir);
        }
        int offset =  pr.page * pr.size;
        strBuilder.append(" OFFSET ").append(offset)
                .append(" FETCH NEXT ").append(pr.size)
                .append(" ROWS ONLY");
        return strBuilder.toString();
    }
}