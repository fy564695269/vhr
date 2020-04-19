package com.example.springbootvhr.entity;

import java.util.List;

public class RespPageBean {
    private Long total;
    private List<?> data; //?可以是任何数据

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
