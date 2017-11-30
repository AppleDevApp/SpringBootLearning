package com.appledevapp.learning.properties.config;

import com.appledevapp.learning.properties.base.SpringbootTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MultiObjectConfigTest extends SpringbootTestBase {

    @Autowired
    private MultiObjectConfig multiObjectConfig;

    @Test
    public void testMultiMapper() throws Exception {
        Assert.assertEquals(multiObjectConfig.getConfigMap().size(), 3);
        Assert.assertEquals(multiObjectConfig.getConfigMap().get("userKey"), "userValue");
        Assert.assertEquals(multiObjectConfig.getConfigMap().get("otherKey"), "otherValue");
        Assert.assertEquals(multiObjectConfig.getConfigMap().get("someKey"), "http://www.appledevapp.com");
    }

    @Test
    public void testMultiString() throws Exception {
        Assert.assertEquals(multiObjectConfig.getConfigList().size(), 4);
        Assert.assertEquals(multiObjectConfig.getConfigList().get(0), "One");
        Assert.assertEquals(multiObjectConfig.getConfigList().get(1), "Two");
        Assert.assertEquals(multiObjectConfig.getConfigList().get(2), "Trd");
        Assert.assertEquals(multiObjectConfig.getConfigList().get(3), "Fou");
    }

    @Test
    public void testMultiObject() throws Exception {
        Assert.assertEquals(multiObjectConfig.getConfigItems().size(), 2);
        Assert.assertEquals(multiObjectConfig.getConfigItems().get(0).getName(), "DevUser");
        Assert.assertEquals(multiObjectConfig.getConfigItems().get(0).getTitle(), "DevHome");
        Assert.assertEquals(multiObjectConfig.getConfigItems().get(1).getName(), "ProdUser");
        Assert.assertEquals(multiObjectConfig.getConfigItems().get(1).getTitle(), "ProdHome");
    }

}