package com.appledevapp.learning.properties.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 应用程序配置-带前缀过滤
 */
@Component
@Validated
@ConfigurationProperties(prefix = "com.appledevapp.config.application")
public class ApplicationPrefixConfig {

    /**
     * 跟@Value配置不同，这里只会设置为null值，如果键值找不到
     */
    private String name;

    /**
     * 配置名称必须跟属性名一致，大小写不区分
     */
    private String nickName;

    /**
     * 类似int这种，非包装类型，会给java默认值
     */
    private int liveAge;

    /**
     * 配置环境中，设定的环境变量
     * 可以加上验证器
     */
    @NotEmpty
    private String env;

    /**
     * 未知属性
     */
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

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getUnKnown() {
        return unKnown;
    }

    public void setUnKnown(String unKnown) {
        this.unKnown = unKnown;
    }
}
