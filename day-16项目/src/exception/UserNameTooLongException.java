package com.lanou3g.exception;

public class UserNameTooLongException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名过长异常";
    }
}
