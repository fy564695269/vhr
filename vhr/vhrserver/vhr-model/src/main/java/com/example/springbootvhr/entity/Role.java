package com.example.springbootvhr.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:49
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 383926775568160951L;

    private Integer id;

    private String name;
    /**
     * 角色名称
     */
    private String nameZh;

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}