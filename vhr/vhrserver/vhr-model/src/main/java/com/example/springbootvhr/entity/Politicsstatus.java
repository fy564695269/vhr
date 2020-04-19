package com.example.springbootvhr.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * (Politicsstatus)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:50
 */
public class Politicsstatus implements Serializable {
    private static final long serialVersionUID = 891442501953745649L;

    private Integer id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Politicsstatus that = (Politicsstatus) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Politicsstatus() {
    }

    public Politicsstatus(String name) {
        this.name = name;
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