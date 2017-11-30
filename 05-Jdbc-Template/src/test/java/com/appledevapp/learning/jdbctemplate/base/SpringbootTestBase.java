package com.appledevapp.learning.jdbctemplate.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTestBase {

    protected static final Log log = LogFactory.getLog(SpringbootTestBase.class);

}
