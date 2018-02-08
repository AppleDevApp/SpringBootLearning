package com.appledevapp.learning.excelexport.function;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.function.Function;

/**
 * 数据格式化函数
 */
public final class FormatFunc {

    /**
     * 时间格式化-日期
     */
    public static final String DATE_STYLE = "yyyy-MM-dd";

    /**
     * 日期格式化-时间和日期
     */
    public static final String DATE_TIME_STYLE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 数字无小数格式
     */
    public static final String NUMBER_ZERO_STYLE = "0";

    /**
     * 数字一位小数格式
     */
    public static final String NUMBER_ONE_STYLE = "0.0";

    /**
     * 数字两位小数格式
     */
    public static final String NUMBER_TWO_STYLE = "0.00";

    /**
     * 空白字符
     */
    public static final String EMPTY_BLANK = "";

    /**
     * 默认格式化-转换为字符
     */
    public static final Function<Object, String> DEFAULT_FORMAT = Object::toString;

    /**
     * 默认日期格式化函数
     */
    public static final Function<Object, String> DATE_FORMAT = (object) -> {
        SimpleDateFormat dateFm = new SimpleDateFormat(DATE_STYLE);
        return dateFm.format(new java.util.Date());
    };

    /**
     * 默认时间格式化函数
     */
    public static final Function<Object, String> DATE_TIME_FORMAT = (object) -> {
        SimpleDateFormat dateFm = new SimpleDateFormat(DATE_TIME_STYLE);
        return dateFm.format(new java.util.Date());
    };

    /**
     * 默认无小数格式化
     */
    public static final Function<Object, String> DECIMAL_ZERO_FORMAT = (object) -> new DecimalFormat(NUMBER_ZERO_STYLE).format(object);

    /**
     * 默认一位小数格式化
     */
    public static final Function<Object, String> DECIMAL_ONE_FORMAT = (object) -> new DecimalFormat(NUMBER_ONE_STYLE).format(object);

    /**
     * 默认两位小数格式化
     */
    public static final Function<Object, String> DECIMAL_TWO_FORMAT = (object) -> new DecimalFormat(NUMBER_TWO_STYLE).format(object);

}
