package service;

import domain.User;
import userdao.UserDao;

public class UserService {
         private   UserDao ud = new UserDao();

            public void register(User user){
                ud.insert(user);
            }


            public  User login(User user){
                User userD = ud.queryByUserName(user);
                return userD;
            }
}
