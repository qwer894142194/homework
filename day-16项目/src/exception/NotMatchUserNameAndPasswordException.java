package com.lanou3g.exception;

public class NotMatchUserNameAndPasswordException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名与密码不匹配异常";
    }
}
