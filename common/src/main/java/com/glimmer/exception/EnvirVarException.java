package com.glimmer.exception;

/**
 * 从环境变量获取访问凭证异常
 */
public class EnvirVarException extends BaseException {
    public EnvirVarException(){}
    public EnvirVarException(String msg){super(msg);}
}
