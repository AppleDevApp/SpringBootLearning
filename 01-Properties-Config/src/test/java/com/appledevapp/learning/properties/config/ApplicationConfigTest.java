package com.appledevapp.learning.properties.config;

import com.appledevapp.learning.properties.base.SpringbootTestBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationConfigTest extends SpringbootTestBase {

    private static final Log log = LogFactory.getLog(ApplicationConfigTest.class);

    @Autowired
    private ApplicationConfig applicationConfig;

    /**
     * Dev时测试才通过
     * spring.profiles.active=dev
     *
     * @throws Exception
     */
    @Test
    public void testApplicationConfig() throws Exception {
        Assert.assertEquals(applicationConfig.getName(), "SpringBoot Learing");
        Assert.assertEquals(applicationConfig.getNickName(), "AppleDevApp");
        Assert.assertEquals(applicationConfig.getLiveAge(), 10);

        log.info("默认状态下，环境变量:" + applicationConfig.getEnviroment());
    }

    /**
     * Test时测试才通过
     * spring.profiles.active=test
     *
     * @throws Exception
     */
    @Test
    public void testMultiConfigValue() throws Exception {
        Assert.assertEquals(applicationConfig.getLiveAge(), 20);
        Assert.assertEquals(applicationConfig.getEnviroment(), "Test");
    }

    /**
     * 未指定spring.profiles.active时测试才通过
     * 主要是为了明白，如果未指定，按照默认值
     *
     * @throws Exception
     */
    @Test
    public void testUnknownProfile() throws Exception {
        Assert.assertEquals(applicationConfig.getEnviroment(), "Normal");

        //通过这个属性可以得知，配置文件，已存在键值会被后面的覆盖
        //独立配置文件里的键值，没启用下不影响
        log.info("配置Unknown值，从当前环境获取为：" + applicationConfig.getUnKnown());
    }

}