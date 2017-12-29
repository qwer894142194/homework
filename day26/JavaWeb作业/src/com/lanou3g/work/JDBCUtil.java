package com.lanou3g.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection coll(){
        Connection root=null;
        try {
             root = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermessage", "root", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return root;

    }
    public static int show(String user,String passwd){
        int i=0;
        try {
             i= new QueryUtil().update(coll(), "insert into user values(null,?,?)", user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
