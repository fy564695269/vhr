package com.example.springbootvhr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * (Joblevel)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:50
 */
public class Joblevel implements Serializable {
    private static final long serialVersionUID = -18736330082001117L;

    private Integer id;
    /**
     * 职称名称
     */
    private String name;

    private String titleLevel;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joblevel joblevel = (Joblevel) o;
        return Objects.equals(name, joblevel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Joblevel() {
    }

    public Joblevel(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    private Boolean enabled;

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
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