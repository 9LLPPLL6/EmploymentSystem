package com.glimmer.exception;

/**
 * 业务异常，所有业务异常都继承这个类
 */
public class BaseException extends RuntimeException {
    public BaseException() {

    }

    public BaseException(String msg) {
        super(msg);
    }
}
