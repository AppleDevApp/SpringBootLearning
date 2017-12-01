package com.appledevapp.learning.jpatemplate.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 账单实体类
 * 如果表名没指定，会异常，因为名字规则不一致，找不到表
 */
@Entity
@Table(name = "month_payment")
public class MonthPayMent {

    /**
     * 自增id，记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 薪资多少
     */
    private BigDecimal salary;

    public MonthPayMent() {
    }

    public MonthPayMent(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

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
