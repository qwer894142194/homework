package com.lanou3g.useoperate;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    private static String url;
    private static String user;
    private static String password;
    private static String database;

    static{
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/jdbc.properties"));

            String driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            database = prop.getProperty("database");

            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n\t\t" + "请将配置文件jdbc.properties放到src目录下");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {

        try {
            Connection coon = DriverManager.getConnection(
                    url+database,
                    user,
                    password);
            return coon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void execute(ExecuteInter e){
        try {
            Connection coon = DriverManager.getConnection(
                    url+database,
                    user,
                    password);
            e.execute(coon).close();
            coon.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void showRs(ResultSet rs){

        try {
            while (rs.next()){
                System.out.print(rs.getString(1) + "\t");

                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
