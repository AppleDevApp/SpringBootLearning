package com.appledevapp.learning.redistemplate;

import com.appledevapp.learning.redistemplate.entity.MonthPayMent;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearningRedisTemplateApplicationTests {

    @Test
    public void contextLoads() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        MonthPayMent payMent = new MonthPayMent();
        payMent.setName("hello");
        payMent.setSalary(BigDecimal.valueOf(10.12));
        payMent.setId(103);

        MonthPayMent payMent2 = new MonthPayMent();
        payMent2.setName("hello");
        payMent2.setSalary(BigDecimal.valueOf(10.12));
        payMent2.setId(104);

        List dataList = new ArrayList();
        dataList.add(payMent);
        dataList.add(payMent2);

        System.out.println(objectMapper.writeValueAsString(dataList));
        byte[] dataBytes = objectMapper.writeValueAsBytes(dataList);
        String reData = new String(dataBytes);
        System.out.println(reData);



    }

}
