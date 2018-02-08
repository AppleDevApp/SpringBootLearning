package com.appledevapp.learning.excelexport.util;

import org.apache.commons.beanutils.BeanMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据转换函数
 */
public class DataConvertor {

    /**
     * 把对象转换为MAP列表格式
     *
     * @param dataList 数据列表
     * @return 转换后列表
     */
    public static List<Map<Object, Object>> toMapList(List dataList) {
        List<Map<Object, Object>> mapList = new ArrayList<>();
        for (Object object : dataList) {
            mapList.add(toMap(object));
        }
        return mapList;
    }

    /**
     * 把对象转换为MAP格式
     *
     * @param data 数据对象
     * @return MAP格式对象
     */
    public static Map<Object, Object> toMap(Object data) {
        return new BeanMap(data);
    }
}
