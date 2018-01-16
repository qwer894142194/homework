package com.lanou3g.service;

import com.lanou3g.bean.User;
import com.lanou3g.dao.UserDao;
import com.lanou3g.service.exception.LoginUsernameNotExist;
import com.lanou3g.service.exception.RegisterException;

import javax.security.auth.login.LoginException;

public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User fromU) throws LoginUsernameNotExist, LoginException {

       User  fromDd = userDao.queryByUsername(fromU);
        if (fromDd == null){
            throw new LoginUsernameNotExist();
        }if (!(fromDd.getUsername().equals(fromU.getPassword()))){
             throw new LoginException();
        }else{
            return fromDd;
        }
    }

    public boolean register(User fromU) throws RegisterException {
        User userDd = userDao.queryByUsername(fromU);
        if (userDd !=null){
            userDao.insert(fromU);
            return true;
        }
        else{
            throw new RegisterException();
        }
    }
}
