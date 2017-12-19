package com.lanou3g.exception;

public class UserNameTooShortException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名过短异常";
    }
}
