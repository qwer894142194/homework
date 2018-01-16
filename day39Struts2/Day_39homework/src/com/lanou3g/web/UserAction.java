package com.lanou3g.web;

import com.lanou3g.bean.User;
import com.lanou3g.service.UserService;
import com.lanou3g.service.exception.LoginUsernameNotExist;
import com.lanou3g.service.exception.RegisterException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UserAction extends ActionSupport {
private UserService us = new UserService();
    private HttpServletRequest request;
    private HttpServletResponse response;

    public  String register() throws IOException, ServletException, RegisterException {
        Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
        User fromU = new User();
        try {
            BeanUtils.populate(fromU,parameterMap);
            boolean rb = us.register(fromU);
            if (rb = true){
                response.sendRedirect("/index.jsp");
            }else{
                    return null;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return SUCCESS;
    }

    public String login() throws IOException, ServletException, LoginException, LoginUsernameNotExist {
        Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
        User fromU = new User();
        try {
            BeanUtils.populate(fromU,parameterMap);
            User fromDd = us.login(fromU);
            if (fromDd !=null){
                response.sendRedirect("/index.jsp");
            }else{
                return null;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
