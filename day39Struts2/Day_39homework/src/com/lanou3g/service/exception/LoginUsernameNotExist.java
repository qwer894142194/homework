package com.lanou3g.service.exception;

public class LoginUsernameNotExist extends Exception{
    @Override
    public String getMessage() {
        return "账号不存在";
    }
}
