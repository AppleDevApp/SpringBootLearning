package com.appledevapp.learning.redistemplate.base;

/**
 * 错误信息包装类，封装Rest响应信息
 */
public class ErrorInfo<T> {

    /**
     * 处理成功标示
     */
    public static final int SUCCESS = 0;

    /**
     * 处理失败标示
     */
    public static final int FAILED = 100;

    /**
     * 状态标示码
     */
    private int code;

    /**
     * 提示消息
     */
    private String message;

    /**
     * 错误关联的地址
     */
    private String url;

    /**
     * 响应数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
