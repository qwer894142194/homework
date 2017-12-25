package com.lanou3g.executeing;

import com.lanou3g.database.JdbcUtil;
import com.lanou3g.dbUtil.DbQueryRunner;
import com.lanou3g.userdao.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Query {

//        1.如果想要一个数组:new ArrayHandler()//1
//        2.如果想要一个数组的集合:new ArrayListHandler()//2
//        4.如果想要一个对象: new BeanHandler<User>(User.class)//4
//        5.如果想要一个对象的集合:new BeanListHandler<>(User.class)//5
//        6.如果想要一个Map:new MapHandler()
//        7.如果你需要一个Map集合:new MapListHandler()
//        3.如果结果集未单行单列:new ScalarHandler<Long>()//3
public static void main(String[] args) {
    query();
//    try {
//        List<Object[]> query1 = new DbQueryRunner().query(
//                JdbcUtil.getConn(),
//                "select * from stu_user",
//                new ArrayListHandler()
//
//        );
//        for (Object[] objects : query1) {
//            System.out.println(Arrays.toString(objects));
//        }
//
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }




}

    public static List<User>  query() {
        try {
            List<User> users = new DbQueryRunner().query(
                    JdbcUtil.getConn(),
                    "select * from stu_user",
                    new BeanListHandler<>(User.class)
            );

            for (User u : users) {
                System.out.println(u);
            }

            return users;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }




}
