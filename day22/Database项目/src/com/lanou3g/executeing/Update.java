package com.lanou3g.executeing;

import com.lanou3g.database.ExecuteInter;
import com.lanou3g.database.JdbcUtil;
import com.lanou3g.userdao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        JdbcUtil.execute(new ExecuteInter() {
            @Override
            public Statement execute(Connection conn, User u) throws SQLException {


                String sql = "";
                PreparedStatement prep = conn.prepareStatement("UPDATE stu_user SET passWord = ? WHERE name = ?");
                prep.setString(1,"12456");
                prep.setString(2,"z");
//                prep.setString(3,"z");
//                prep.setString(4,"z");
                prep.addBatch();
                prep.executeBatch();

                return prep;
            }
        },new User());




    }
}
