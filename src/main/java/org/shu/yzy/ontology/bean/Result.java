package org.shu.yzy.ontology.bean;

import lombok.Data;
import org.shu.yzy.ontology.enums.ResultEnum;

@Data
public class Result<T> {
    private int code;

    private String msg;

    /**当前用户的角色列表*/
    private String role;

    private T data;

    public static  <T> Result<T> getResult(ResultEnum resultEnum, T data){
        //TODO
        return new Result<T>(resultEnum.getCode(), resultEnum.getMsg(), data, "admin");
    }

    public static  <T> Result<T> getResult(ResultEnum resultEnum){
        return new Result<T>(resultEnum.getCode(), resultEnum.getMsg());
    }

    public static <T> Result<T> getResult(int code, String msg){
        return new Result<T>(code, msg);
    }

    public Result(int code, String msg, T data, String role) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.role = role;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}