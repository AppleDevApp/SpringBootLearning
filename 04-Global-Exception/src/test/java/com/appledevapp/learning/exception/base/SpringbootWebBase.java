package com.appledevapp.learning.exception.base;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class SpringbootWebBase extends SpringbootTestBase {

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        //MockMvcBuilders使用构建MockMvc对象（项目拦截器有效）
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        //单个类  拦截器无效
        //mockMvc = MockMvcBuilders.standaloneSteup(userController).build();
    }

}
