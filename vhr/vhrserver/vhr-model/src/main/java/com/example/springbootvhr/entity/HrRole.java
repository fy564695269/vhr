package com.example.springbootvhr.entity;

import java.io.Serializable;

/**
 * (HrRole)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:49
 */
public class HrRole implements Serializable {
    private static final long serialVersionUID = 308726174068758474L;

    private Integer id;

    private Integer hrid;

    private Integer rid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}