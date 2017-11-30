package com.appledevapp.learning.properties.config;

import com.appledevapp.learning.properties.entity.ConfigItem;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对象动态配置
 */
@Component
@ConfigurationProperties(prefix = "com.appledevapp.multiobject")
public class MultiObjectConfig {

    /**
     * 配置明细项列表 - 对象列表
     */
    private List<ConfigItem> configItems = new ArrayList<>();

    /**
     * 配置明细项列表 - 字符串列表
     */
    private List<String> configList = new ArrayList<>();

    /**
     * 配置明细项字典
     */
    private Map<String,String> configMap = new HashMap<>();

    public List<ConfigItem> getConfigItems() {
        return configItems;
    }

    public void setConfigItems(List<ConfigItem> configItems) {
        this.configItems = configItems;
    }

    public List<String> getConfigList() {
        return configList;
    }

    public void setConfigList(List<String> configList) {
        this.configList = configList;
    }

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, String> configMap) {
        this.configMap = configMap;
    }
}
