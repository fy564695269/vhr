package com.example.springbootvhr.entity;

import java.io.Serializable;

/**
 * (Oplog)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:49
 */
public class Oplog implements Serializable {
    private static final long serialVersionUID = -20985420145942377L;

    private Integer id;
    /**
     * 添加日期
     */
    private Object adddate;
    /**
     * 操作内容
     */
    private String operate;
    /**
     * 操作员ID
     */
    private Integer hrid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getAdddate() {
        return adddate;
    }

    public void setAdddate(Object adddate) {
        this.adddate = adddate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

}