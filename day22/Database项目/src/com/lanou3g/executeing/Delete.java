package com.lanou3g.executeing;

import com.lanou3g.database.ExecuteInter;
import com.lanou3g.database.JdbcUtil;
import com.lanou3g.userdao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    public static void main(String[] args) {
        JdbcUtil.execute(new ExecuteInter() {
            @Override
            public Statement execute(Connection conn, User u) throws SQLException {
                String sql = "DELETE FROM stu_user WHERE name =?";
                PreparedStatement prep = conn.prepareStatement(sql);
                prep.setString(1,"张三");
                prep.execute();
                prep.setString(1,"王五");
                prep.execute();



                return prep;
            }
        },new User());




    }

}
