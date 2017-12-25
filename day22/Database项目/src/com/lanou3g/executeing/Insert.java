package com.lanou3g.executeing;

import com.lanou3g.database.ExecuteInter;
import com.lanou3g.database.JdbcUtil;
import com.lanou3g.userdao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {

        User user = new User("王五","wangWu","125454893");


        JdbcUtil.execute(new ExecuteInter() {
            @Override
            public Statement execute(Connection conn, User u) throws SQLException {
                String sql="INSERT INTO stu_user VALUES(?,?,?)";

                PreparedStatement prep = conn.prepareStatement(sql);
                prep.setString(1,u.getName());
                prep.setString(2,u.getUserName());
                prep.setString(3,u.getPassWord());
                prep.addBatch();
                prep.executeBatch();

                return prep;

            }
        },user);
    }



}
