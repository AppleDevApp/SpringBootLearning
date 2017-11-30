package com.appledevapp.learning.jdbctemplate.service;

import com.appledevapp.learning.jdbctemplate.datalayer.MonthPaymentDao;
import com.appledevapp.learning.jdbctemplate.entity.MonthPayMent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthPaymentServiceImpl implements MonthPaymentService {

    @Autowired
    private MonthPaymentDao monthPaymentDao;

    @Override
    public int add(MonthPayMent payMent) {
        return monthPaymentDao.add(payMent);
    }

    @Override
    public int update(MonthPayMent payMent) {
        return monthPaymentDao.update(payMent);
    }

    @Override
    public int delete(int id) {
        return monthPaymentDao.delete(id);
    }

    @Override
    public MonthPayMent findPaymentById(int id) {
        return monthPaymentDao.findPaymentById(id);
    }

    @Override
    public List<MonthPayMent> findPaymentList() {
        return monthPaymentDao.findPaymentList();
    }
}
