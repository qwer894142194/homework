package com.lanou3g.database;

import com.lanou3g.userdao.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    static {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("src/jdbc.properties"));
            String driverName = prop.getProperty("driverName");
            database = prop.getProperty("database");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String database;
    private static String url;
    private static String user;
    private static String password;

    public static Connection getConn(){
        try {
            Connection conn = DriverManager.getConnection(url+database,user,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void execute(ExecuteInter e, User u){
        try {
            Connection conn = DriverManager.getConnection(url + database, user, password);
            e.execute(conn,u).close();
            conn.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }


    }





}




