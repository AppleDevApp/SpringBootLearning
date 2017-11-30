package com.appledevapp.learning.properties.config;

import com.appledevapp.learning.properties.base.SpringbootTestBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DynamicGeneralConfigTest extends SpringbootTestBase {

    private static final Log log = LogFactory.getLog(DynamicGeneralConfigTest.class);


    @Autowired
    private DynamicGeneralConfig dynamicGeneralConfig;

    @Test
    public void testDynamicReference() throws Exception {
        Assert.assertEquals(dynamicGeneralConfig.getReferenceName(), "Spring Reading");
        Assert.assertEquals(dynamicGeneralConfig.getReferenceWork(), "Doing work");
        Assert.assertEquals(dynamicGeneralConfig.getFullJob(), String.format("%s want to %s", dynamicGeneralConfig.getReferenceName(), dynamicGeneralConfig.getReferenceWork()));
    }

    @Test
    public void testDynamicGeneral() throws Exception {

        log.info("动态生成字符串：" + dynamicGeneralConfig.getRandomString());
        log.info("动态生成数字：" + dynamicGeneralConfig.getRandomInt());
        log.info("动态生成大数字：" + dynamicGeneralConfig.getRandomLong());
        log.info("动态生成范围数字：" + dynamicGeneralConfig.getRangeLess());
        log.info("动态生成范围数字：" + dynamicGeneralConfig.getRangeOver());

    }

}