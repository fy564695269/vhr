package com.example.springbootvhr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * (Position)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:49
 */
public class Position implements Serializable {
    private static final long serialVersionUID = 755333510979407830L;

    private Integer id;
    /**
     * 职位
     */
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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