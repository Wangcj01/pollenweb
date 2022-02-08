package com.pollen.pollenweb.result;

/**
 * @CaesarYang
 * 2022.1
 */

public enum ResponseEnum {
    USER_INFO_NULL(1001,"用户信息不能为空"),
    USERNAME_NOT_EXISTITS(1002,"用户名不存在"),
    PASSWORD_ERROR(1003,"密码错误"),
    USER_NAME_EXISTS(1004,"用户名已存在"),
    EMAIL_ERROR(1003,"邮箱格式错误"),
    USER_REGISTER_ERROR(1004,"用户注册失败");

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    private Integer code;//状态码
    private String msg;//消息

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
