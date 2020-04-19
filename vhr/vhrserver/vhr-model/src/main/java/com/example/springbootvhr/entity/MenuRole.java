package com.example.springbootvhr.entity;

import java.io.Serializable;

/**
 * (MenuRole)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:50
 */
public class MenuRole implements Serializable {
    private static final long serialVersionUID = 307794747843018295L;

    private Integer id;

    private Integer mid;

    private Integer rid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}