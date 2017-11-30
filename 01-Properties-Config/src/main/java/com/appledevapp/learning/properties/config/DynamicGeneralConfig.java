package com.appledevapp.learning.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 动态内容配置，动态生成
 */
@Component
public class DynamicGeneralConfig {

    /**
     * 引用名称
     */
    @Value("${com.appledevapp.reference.name}")
    private String referenceName;

    /**
     * 引用工作
     */
    @Value("${com.appledevapp.reference.work}")
    private String referenceWork;

    /**
     * 完整引用，组合前面两个属性内容
     */
    @Value("${com.appledevapp.reference.job}")
    private String fullJob;

    /**
     * 动态生成 字符串内容
     */
    @Value("${com.appledevapp.general.value}")
    private String randomString;

    /**
     * 动态生成 数字内容
     */
    @Value("${com.appledevapp.general.number}")
    private int randomInt;

    /**
     * 动态生成 数字内容
     */
    @Value("${com.appledevapp.general.bignumber}")
    private long randomLong;

    /**
     * 动态生成 区域段数字内容
     */
    @Value("${com.appledevapp.general.rangeless}")
    private int rangeLess;

    /**
     * 动态生成 区域段数字内容
     */
    @Value("${com.appledevapp.general.rangeover}")
    private int rangeOver;

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferenceWork() {
        return referenceWork;
    }

    public void setReferenceWork(String referenceWork) {
        this.referenceWork = referenceWork;
    }

    public String getFullJob() {
        return fullJob;
    }

    public void setFullJob(String fullJob) {
        this.fullJob = fullJob;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(long randomLong) {
        this.randomLong = randomLong;
    }

    public int getRangeLess() {
        return rangeLess;
    }

    public void setRangeLess(int rangeLess) {
        this.rangeLess = rangeLess;
    }

    public int getRangeOver() {
        return rangeOver;
    }

    public void setRangeOver(int rangeOver) {
        this.rangeOver = rangeOver;
    }
}
