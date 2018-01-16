package com.lanou3g.service.exception;

public class RegisterException extends Exception{
    @Override
    public String getMessage() {
        return "账号已存在";
    }
}
