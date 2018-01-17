package action;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import org.apache.struts2.ServletActionContext;
import service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private String password1;
    private String code = (String) ServletActionContext.getRequest().getAttribute("code");
    private UserService us = new UserService();

    public  String register(){
        System.out.println(code);
        us.register(user);
        return SUCCESS;
    }

    public  String login(){
        return SUCCESS;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public User getUser() {
        return user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUser(User user) {

        this.user = user;
    }

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void validate() {
        System.out.println(password1);
        if (!user.getPassword().equals(password1)){
            addFieldError("surePassWord","俩次密码不相同");
        }

    }
}
