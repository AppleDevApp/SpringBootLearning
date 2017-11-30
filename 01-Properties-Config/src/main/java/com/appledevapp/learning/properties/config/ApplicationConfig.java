package com.appledevapp.learning.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 应用程序配置
 */
@Component
public class ApplicationConfig {

    /**
     * 指定配置文件中的配置名称，如果配置文件中不存在，会抛出异常
     */
    @Value("${com.appledevapp.config.application.name}")
    private String name;

    /**
     * 配置名称可以和属性名不一样，类型要能转换成功
     */
    @Value("${com.appledevapp.config.application.nickname}")
    private String nickName;

    /**
     * 配置文件中未配置，可以配置默认值
     */
    @Value("${com.appledevapp.config.application.days:10}")
    private int liveAge;

    /**
     * 配置环境中，设定的环境变量
     */
    @Value("${com.appledevapp.config.application.env}")
    private String enviroment;

    /**
     * 未知属性
     */
    @Value("${com.appledevapp.config.application.unknow:UnConfig}")
    private String unKnown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getLiveAge() {
        return liveAge;
    }

    public void setLiveAge(int liveAge) {
        this.liveAge = liveAge;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    public String getUnKnown() {
        return unKnown;
    }

    public void setUnKnown(String unKnown) {
        this.unKnown = unKnown;
    }
}
