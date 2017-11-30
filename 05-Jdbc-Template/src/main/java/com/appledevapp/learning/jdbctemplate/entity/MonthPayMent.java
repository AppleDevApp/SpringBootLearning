package com.appledevapp.learning.jdbctemplate.entity;

import java.math.BigDecimal;

/**
 * 账单实体类
 */
public class MonthPayMent {

    /**
     * 自增id，记录id
     */
    private int id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 薪资多少
     */
    private BigDecimal salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
