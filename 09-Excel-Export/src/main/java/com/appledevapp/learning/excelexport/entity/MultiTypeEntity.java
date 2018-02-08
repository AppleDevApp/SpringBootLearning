package com.appledevapp.learning.excelexport.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MultiTypeEntity implements Serializable {

    private Long id;
    private Integer age;
    private String name;
    private BigDecimal payMoney;
    private InnerTypeEntity typeEntity;
    private Date timeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public InnerTypeEntity getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(InnerTypeEntity typeEntity) {
        this.typeEntity = typeEntity;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }
}
