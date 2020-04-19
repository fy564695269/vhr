package com.example.springbootvhr.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * (Nation)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:50
 */
public class Nation implements Serializable {
    private static final long serialVersionUID = -83263724961699811L;

    private Integer id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nation nation = (Nation) o;
        return Objects.equals(name, nation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Nation() {
    }

    public Nation(String name) {
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