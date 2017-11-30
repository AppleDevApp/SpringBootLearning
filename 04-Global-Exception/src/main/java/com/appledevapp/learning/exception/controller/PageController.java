package com.appledevapp.learning.exception.controller;

import com.appledevapp.learning.exception.exception.ParameterInvalidException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * MVC模型控制器 定义路由以及响应
 */
@Controller
public class PageController {

    /**
     * 路径映射，指定请求路径，使用modelandview
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView webIndex() {
        //指定对应的视图模版名称，以及需要填充的数据
        ModelAndView modelView = new ModelAndView("index");
        modelView.addObject("name", "AppleDevApp");
        modelView.addObject("title", "Learning Spring Boot");
        modelView.addObject("pageNum", 1);
        return modelView;
    }

    /**
     * 抛出普通异常，以默认异常处理
     *
     * @return
     */
    @RequestMapping("/exception/normal")
    public String webIndexUsingNormalException() throws Exception {
        throw new Exception("Normal Exception");
    }

    /**
     * 抛出特定标记异常，以JSON异常处理
     *
     * @return
     */
    @RequestMapping("/exception/json")
    public String webIndexUsingRestException() throws Exception {
        throw new ParameterInvalidException("Data Invalid");
    }

}
