package com.boylegu.springboot_vue.controller.pagination;

public class PaginationMultiTypeValuesHelper {

    private Integer count, page;

    private Object results;

    private Long total;

    public void setCount(Integer name) {
        this.count = name;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
