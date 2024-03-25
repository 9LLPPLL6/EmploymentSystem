package com.glimmer.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端同一返回结果类
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static <T>Result<T> success(){
        Result<T> result = new Result<T>();
        result.code = 200;
        result.message = "成功";
        return result;
    }
    public static <T> Result<T> success(String message){
        Result<T> result = new Result<T>();
        result.code = 200;
        result.message = message;
        return result;
    }

    public static <T> Result<T> success(String message,T object){
        Result<T> result = new Result<T>();
        result.code = 200;
        result.message = message;
        result.data = object;
        return result;
    }


    public static <T> Result<T> error(String message, Integer code){
        Result<T> result = new Result<T>();
        result.code = code;
        result.message = message;
        return result;
    }

    public static <T> Result<T> error(String message, Integer code, T object){
        Result<T> result = new Result<T>();
        result.code = code;
        result.message = message;
        result.data = object;
        return result;
    }

    public static <T> Result<T> error(String message){
        Result<T> result = new Result<T>();
        result.message = message;
        return result;
    }



}
