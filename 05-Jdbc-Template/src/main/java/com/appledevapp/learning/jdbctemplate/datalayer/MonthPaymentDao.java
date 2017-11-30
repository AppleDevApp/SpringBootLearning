package com.appledevapp.learning.jdbctemplate.datalayer;

import com.appledevapp.learning.jdbctemplate.entity.MonthPayMent;

import java.util.List;

public interface MonthPaymentDao {

    int add(MonthPayMent payMent);

    int update(MonthPayMent payMent);

    int delete(int id);

    MonthPayMent findPaymentById(int id);

    List<MonthPayMent> findPaymentList();
}
