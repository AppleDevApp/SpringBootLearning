package com.appledevapp.learning.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
     * 使用model时，需要返回视图名称
     *
     * @param model
     * @return
     */
    @RequestMapping("/model")
    public String webIndexUsingModel(Model model) {
        model.addAttribute("name", "AppleDevApp");
        model.addAttribute("title", "Learning Spring Boot");
        model.addAttribute("pageNum", 1);
        return "index";
    }

    /**
     * 使用modelmap时，需要返回视图名称
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/map")
    public String webIndexUsingMap(ModelMap modelMap) {
        modelMap.addAttribute("name", "AppleDevApp");
        modelMap.addAttribute("title", "Learning Spring Boot");
        modelMap.addAttribute("pageNum", 1);
        return "index";
    }

}
