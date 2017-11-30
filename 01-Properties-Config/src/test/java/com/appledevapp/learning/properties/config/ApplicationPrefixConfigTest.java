package com.appledevapp.learning.properties.config;


import com.appledevapp.learning.properties.base.SpringbootTestBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationPrefixConfigTest extends SpringbootTestBase {

    private static final Log log = LogFactory.getLog(ApplicationPrefixConfigTest.class);

    @Autowired
    private ApplicationPrefixConfig applicationPrefixConfig;

    @Autowired
    private ApplicationConfig applicationConfig;

    @Test
    public void testPrefixConfig() throws Exception {
        log.info("Application Config Value :");
        Assert.assertEquals(applicationConfig.getName(), "SpringBoot Learing");
        Assert.assertEquals(applicationConfig.getNickName(), "AppleDevApp");
        Assert.assertEquals(applicationConfig.getLiveAge(), 10);

        log.info("Application Prefix Config Value :");
        Assert.assertEquals(applicationPrefixConfig.getName(), "SpringBoot Learing");
        Assert.assertEquals(applicationPrefixConfig.getNickName(), "AppleDevApp");
        Assert.assertEquals(applicationPrefixConfig.getLiveAge(), 10);
    }
}