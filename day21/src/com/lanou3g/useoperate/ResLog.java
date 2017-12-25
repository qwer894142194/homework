package com.lanou3g.useoperate;

import java.sql.*;
import java.util.Scanner;

public class ResLog {

    public  static  void regiter(){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入账号");
        String username = sc.nextLine();
        System.out.println("请输入账号");
        String password = sc.nextLine();
        System.out.println("请输入名称");
        String name = sc.nextLine();
        JdbcUtil.execute(new ExecuteInter() {
            @Override
            public Statement execute(Connection coon) throws SQLException {
               PreparedStatement pstate  = coon.prepareStatement("INSERT  INTO res_log VALUES (?,?,?");
               pstate.setString(1,username);
               pstate.setString(2,password);
               pstate.setString(3,name);
            }
        });


        }
}
