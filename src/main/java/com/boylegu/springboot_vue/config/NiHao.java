package com.boylegu.springboot_vue.config;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.List;

public class NiHao {

    private Integer count, page;
    //private List<String> phoneNumbers = Collections.emptyList();

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
}
