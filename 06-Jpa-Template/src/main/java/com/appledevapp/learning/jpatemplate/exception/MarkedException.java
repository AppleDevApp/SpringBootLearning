package com.appledevapp.learning.jpatemplate.exception;

/**
 * 已标记异常抽象类 用于Rest异常输出
 */
public abstract class MarkedException extends Exception {

    public MarkedException(String message) {
        super(message);
    }
}
