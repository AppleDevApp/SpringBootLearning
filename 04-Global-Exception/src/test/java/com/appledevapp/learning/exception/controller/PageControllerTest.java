package com.appledevapp.learning.exception.controller;

import com.appledevapp.learning.exception.base.ErrorInfo;
import com.appledevapp.learning.exception.base.SpringbootWebBase;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PageControllerTest extends SpringbootWebBase {

    /**
     * 测试抛出普通异常
     *
     * @throws Exception
     */
    @Test
    public void webIndexUsingNormalException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/exception/normal").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("Easy to use")));
    }

    /**
     * 测试抛出JSON异常
     * @throws Exception
     */
    @Test
    public void webIndexUsingRestException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/exception/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.INTERNAL_SERVER_ERROR.value())).andDo(print())
                .andExpect(jsonPath("$.code").value(ErrorInfo.FAILED));
    }

    /**
     * 测试不同的请求方法
     * @throws Exception
     */
    @Test
    public void sendHttpRequest() throws Exception {
        JSONObject param = new JSONObject();
        param.put("userId", "");
        String paramJson = param.toString();
        System.out.println("================================请求入参：" + paramJson);
        RequestBuilder request = MockMvcRequestBuilders.post("/exception/json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(paramJson);

        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertTrue("响应正确", status == 500);

        log.info("响应状态：" + status);
        log.info("响应内容:" + content);
    }

}