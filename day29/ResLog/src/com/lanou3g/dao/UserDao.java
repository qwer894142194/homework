package com.lanou3g.dao;

import com.lanou3g.main.User;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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

    public  User queryAll1(){
        String sql = "select * from  user";
        Connection conn = null;
        conn= JdbcUtil.getConnection();
        try {
            User user = qr.query(conn, sql, new BeanHandler<User>(User.class));
            return  user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
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


}
