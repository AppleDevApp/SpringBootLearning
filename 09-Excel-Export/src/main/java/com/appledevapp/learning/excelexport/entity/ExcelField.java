package com.appledevapp.learning.excelexport.entity;

import com.appledevapp.learning.excelexport.function.FormatFunc;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Excel映射字段
 */
public class ExcelField {

    /**
     * 字段中文名(列名)
     */
    private String cnFieldName;

    /**
     * 字段类型，虚拟字段OR原生字段
     */
    private FieldType fieldType;

    /**
     * 格式化函数
     */
    private Function<Object, String> formatFunc;

    /**
     * 数据提供者函数
     */
    private BiFunction<Map<Object, Object>, Integer, Object> providerFunc;

    /**
     * 字段类型
     */
    public enum FieldType {
        /**
         * 原生字段
         */
        NativeField,

        /**
         * 虚拟字段
         */
        VirtualField
    }

    /**
     * 构造函数-原生字段,采用默认的字符格式化
     *
     * @param cnFieldName 列名
     */
    public ExcelField(String cnFieldName) {
        this.fieldType = FieldType.NativeField;
        this.cnFieldName = cnFieldName;
        this.formatFunc = FormatFunc.DEFAULT_FORMAT;
    }

    /**
     * 构造函数-原生字段,采用默认的字符格式化
     *
     * @param cnFieldName 列名
     * @param formatFunc  格式化函数
     */
    public ExcelField(String cnFieldName, Function<Object, String> formatFunc) {
        this.fieldType = FieldType.NativeField;
        this.cnFieldName = cnFieldName;
        this.formatFunc = formatFunc;
    }

    /**
     * 构造函数-虚拟字段，必须提供数据提供者函数，采用默认的字符格式化
     *
     * @param cnFieldName  列名
     * @param providerFunc 数据提供者函数，提供字段数据
     */
    public ExcelField(String cnFieldName, BiFunction<Map<Object, Object>, Integer, Object> providerFunc) {
        this.fieldType = FieldType.VirtualField;
        this.cnFieldName = cnFieldName;
        this.formatFunc = FormatFunc.DEFAULT_FORMAT;
        this.providerFunc = providerFunc;
    }

    /**
     * 构造函数-虚拟字段，必须提供数据提供者函数,自定义格式化函数
     *
     * @param cnFieldName  列名
     * @param formatFunc   格式化函数
     * @param providerFunc 数据提供者函数，提供字段数据
     */
    public ExcelField(String cnFieldName, Function<Object, String> formatFunc, BiFunction<Map<Object, Object>, Integer, Object> providerFunc) {
        this.fieldType = FieldType.VirtualField;
        this.cnFieldName = cnFieldName;
        this.formatFunc = formatFunc;
        this.providerFunc = providerFunc;
    }

    /**
     * 应用函数生成数据转换
     *
     * @param dataMap   数据字典
     * @param rowNum    当前序号
     * @param fieldName 字段英文名
     * @return 字符串格式数据
     */
    public String applyFunc(Map<Object, Object> dataMap, Integer rowNum, String fieldName) {

        Object fieldObj;
        if (this.fieldType == FieldType.NativeField) {
            fieldObj = dataMap.get(fieldName);
        } else {
            fieldObj = this.providerFunc.apply(dataMap, rowNum);
        }

        if (fieldObj != null) {
            return this.formatFunc.apply(fieldObj);
        }

        return FormatFunc.EMPTY_BLANK;
    }

    public String getCnFieldName() {
        return cnFieldName;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public Function<Object, String> getFormatFunc() {
        return formatFunc;
    }

    public BiFunction<Map<Object, Object>, Integer, Object> getProviderFunc() {
        return providerFunc;
    }
}
