package com.lanou3g.exception;

public class PasswordTooLongException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码过长异常";
    }
}
