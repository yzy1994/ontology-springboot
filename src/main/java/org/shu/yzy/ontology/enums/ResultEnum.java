package org.shu.yzy.ontology.enums;

public enum ResultEnum {
    SUCCESS(200, "success"),
    SERVER_ERROR(101, "服务器异常"),
    BIND_ERROR(102, "参数异常"),
    REQUEST_ILLEGAL(103, "请求非法"),
    ACCESS_LIMIT_REACHED(104, "访问太频繁"),
    LOGIN_FAILED(105, "用户名不存在或密码错误"),
    UNAUTH(401, "未登录");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
