package com.appledevapp.learning.jdbctemplate.controller;

import com.appledevapp.learning.jdbctemplate.entity.MonthPayMent;
import com.appledevapp.learning.jdbctemplate.service.MonthPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

/**
 * MVC模型控制器 定义路由以及响应
 */
@Controller
public class PageController {

    @Autowired
    private MonthPaymentService monthPaymentService;

    /**
     * 获取数据库里列表并展示
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView webIndex() {

        //获取数据
        List<MonthPayMent> recordList = monthPaymentService.findPaymentList();

        //指定对应的视图模版名称，以及需要填充的数据
        ModelAndView modelView = new ModelAndView("index");
        modelView.addObject("payMentList", recordList);
        return modelView;
    }

    /**
     * 新增记录并返回记录id
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public int addPayment() throws Exception {
        MonthPayMent payMent = new MonthPayMent();
        payMent.setName("RandomName" + System.currentTimeMillis());
        payMent.setSalary(BigDecimal.valueOf(12.34));
        int id = monthPaymentService.add(payMent);
        return id;
    }

    /**
     * 根据id去查找记录
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/search/{id}")
    public MonthPayMent searchPayment(@PathVariable("id") int id) throws Exception {
        return monthPaymentService.findPaymentById(id);
    }

}
