package com.example.mybatisplus.model.common;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

@Data
public class PageRequestModel<T> {

    private Long current = 1L;

    private Long size = 10L;

    private String sortBy;

    private Boolean isAsc = true;

    @JsonUnwrapped
    private T model;

    public Page<T> getMpPage() {
        Page<T> page = Page.of(current, size);
        if(StringUtils.isNotBlank(sortBy)){
            page.addOrder(new OrderItem(sortBy, isAsc));
        }
        return page;
    }
}
