package com.appledevapp.learning.properties.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 应用程序环境准备完成监听事件
 * 该事件在上下文创建之前，从而允许设置值到环境变量中
 */
public class AppEnvPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private Logger logger = LoggerFactory.getLogger(AppEnvPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        configEnvProperties(event.getEnvironment());
    }

    /**
     * 配置系统环境属性
     */
    private void configEnvProperties(ConfigurableEnvironment env) {
        String applicationName = env.getProperty("com.appledevapp.config.application.env");
        logger.info("Orgin Application Name:" + applicationName);
        env.getSystemProperties().put("com.appledevapp.config.application.name", "Hello App Env");

        applicationName = env.getProperty("com.appledevapp.config.application.env");
        logger.info("After Application Name:" + applicationName);
    }
}
