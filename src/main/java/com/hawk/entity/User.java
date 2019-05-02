package com.hawk.entity;


import com.hawk.util.SexTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.UnknownTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhangdonghao
 * @date 2019/4/16
 */
@Table(name = "user")
public class User implements Serializable {
    private static final long seriaVersionUID = 1L;
    @Id
    private Integer id;
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;
    @ColumnType(typeHandler = SexTypeHandler.class)
    private String sex;

    private Integer age;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
