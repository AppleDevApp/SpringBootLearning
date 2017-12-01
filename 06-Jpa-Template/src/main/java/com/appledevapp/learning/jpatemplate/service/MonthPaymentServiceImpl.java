package com.appledevapp.learning.jpatemplate.service;

import com.appledevapp.learning.jpatemplate.entity.MonthPayMent;
import com.appledevapp.learning.jpatemplate.exception.ParameterInvalidException;
import com.appledevapp.learning.jpatemplate.repository.MonthPayMentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthPaymentServiceImpl implements MonthPaymentService {

    @Autowired
    private MonthPayMentRepository monthPaymentDao;

    @Override
    public int add(MonthPayMent payMent) {
        return monthPaymentDao.save(payMent).getId();
    }

    @Override
    public int update(MonthPayMent payMent) {
        return monthPaymentDao.updateById(payMent.getName(), payMent.getSalary(), payMent.getId());
    }

    @Override
    public int updateUsingIndex(MonthPayMent payMent) {
        return monthPaymentDao.updateByIdUsingIndex(payMent.getName(), payMent.getSalary(), payMent.getId());
    }

    @Override
    public MonthPayMent updateUsingNative(MonthPayMent payMent) throws Exception {
        if (payMent.getId() <= 0) {
            throw new ParameterInvalidException("记录id不能为空");
        }
        return monthPaymentDao.save(payMent);
    }

    @Override
    public void delete(int id) {
        monthPaymentDao.delete(id);
    }

    @Override
    public MonthPayMent findPaymentById(int id) {
        return monthPaymentDao.findOne(id);
    }

    @Override
    public List<MonthPayMent> findPaymentList() {
        return monthPaymentDao.findAll();
    }
}
