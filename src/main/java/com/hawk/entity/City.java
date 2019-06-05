package com.hawk.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdonghao
 * @date 2019/5/30
 */
@Table(name = "city")
public class City implements Serializable{
    private static final long serialVersionUID = -5882351559712072238L;
    private Integer id;
    private Integer parentId;
    private String name;
    private String level;
    private List<City> cities = new ArrayList<City>();

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
