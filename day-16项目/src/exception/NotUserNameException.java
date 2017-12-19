package com.lanou3g.exception;

public class NotUserNameException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在异常";
    }
}
