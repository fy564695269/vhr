package com.example.springbootvhr.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2020-02-18 20:29:48
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 340361606852925645L;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", depPath='" + depPath + '\'' +
                ", children=" + children +
                ", enabled=" + enabled +
                ", isParent=" + isParent +
                ", result=" + result +
                '}';
    }

    private Integer id;
    /**
     * 部门名称
     */
    private String name;

    private Integer parentId;

    private String depPath;

    private List<Department> children = new ArrayList<>();

    private Boolean enabled;

    private Boolean isParent;

    private Integer result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDepPath() {
        return depPath;
    }

    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

}