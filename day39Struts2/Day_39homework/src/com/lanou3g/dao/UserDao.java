package com.lanou3g.dao;

import com.lanou3g.bean.User;
import com.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
        private QueryRunner qr =  new QueryRunner();

    public User queryByUsername(User fromU) {
        String sql = "select * from user where username=?";
        Connection conn = C3P0Util.getConnection();
        try {
            User fromDd = qr.query(conn, sql, new BeanHandler<User>(User.class), fromU.getUsername());
            return fromDd;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            C3P0Util.release(null,null,conn);
        }
    }

    public void insert(User fromU){
        String sql = "insert into user values(?,?)";
        Connection conn = C3P0Util.getConnection();
        try {
            qr.update(conn,sql,fromU.getUsername(),fromU.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
             C3P0Util.release(null,null,conn);
        }
    }
}
