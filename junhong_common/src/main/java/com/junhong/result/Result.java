package com.junhong.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;//1成功，0和其他数字失败
    private String msg;//错误信息
    private T data;//数据
    public static Result success(){
        Result result=new Result();
        result.code=1;
        return  result;
    }
    public static <T> Result<T> success( T object){
        Result result=new Result();
        result.data=object;
        result.code=1;
        return result;
    }
    public static Result error(String msg){
        Result result=new Result();
        result.code=0;
        result.msg=msg;
        return result;
    }
}
