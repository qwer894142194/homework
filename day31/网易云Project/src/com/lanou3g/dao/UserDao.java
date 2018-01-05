package com.lanou3g.dao;

import com.lanou3g.bean.User;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private QueryRunner qr = new QueryRunner();

    public List<User> queryAll(){
         String sql = "select * from  user";
         Connection conn = null;
         conn= JdbcUtil.getConnection();

        try {
            List<User> users = qr.query(conn, sql, new BeanListHandler<User>(User.class));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtil.close(conn);
        }
        return null;
    }



    public  Boolean queryAll1(String username ,String password) {
        String sql = "select * from where username like " + username;
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            User user = qr.query(conn, sql, new ScalarHandler<User>());
            boolean b = user.getPassword().equals(password);
            if (b==true){
                return  true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }

    public void insertUser(User user){
            String sql = "insert into user values(null,?,?)";
            Connection conn = null;

        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql
                    ,user.getUsername(),user.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
            JdbcUtil.close(conn);
    }


    public User queryByUsername(String username) {
        Connection conn = JdbcUtil.getConnection();
        String sql ="select * from user where username=?";
        try {
            User user = qr.query(conn, sql , new BeanHandler<User>(User.class),username);
            System.out.println(user);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtil.close(conn);

        }

    }
}
