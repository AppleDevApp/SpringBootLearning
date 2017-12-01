package com.appledevapp.learning.jpatemplate.service;

import com.appledevapp.learning.jpatemplate.entity.MonthPayMent;

import java.util.List;

/**
 * 定义服务接口方法
 */
public interface MonthPaymentService {

    /**
     * 新增记录
     *
     * @param payMent
     * @return
     */
    int add(MonthPayMent payMent);

    /**
     * 更新记录
     *
     * @param payMent
     * @return
     */
    int update(MonthPayMent payMent);

    /**
     * 更新记录
     *
     * @param payMent
     * @return
     */
    int updateUsingIndex(MonthPayMent payMent);

    /**
     * 更新记录
     *
     * @param payMent
     * @return
     */
    MonthPayMent updateUsingNative(MonthPayMent payMent) throws Exception;

    /**
     * 删除记录
     *
     * @param id
     */
    void delete(int id);

    /**
     * 根据id寻找记录
     *
     * @param id
     * @return
     */
    MonthPayMent findPaymentById(int id);

    /**
     * 获取记录列表
     *
     * @return
     */
    List<MonthPayMent> findPaymentList();
}
