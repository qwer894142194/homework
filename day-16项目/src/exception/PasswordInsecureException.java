package com.lanou3g.exception;

public class PasswordInsecureException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不安全异常";
    }
}
