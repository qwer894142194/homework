package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by travelround on 17/4/18.
 */
public class C3P0Util {


    // 得到一个数据源(连接池)
    private static DataSource dataSource = new ComboPooledDataSource();


    public static Connection getConnection() {
//静态方法  连接驱动方法
        try {
            return dataSource.getConnection();
            //返回一个连接
        } catch (SQLException e) {
            throw new RuntimeException("服务器忙...");
            //抛出异常 服务器繁忙的异常
        }
    }

    public static void release(ResultSet resultSet, Statement stmt, Connection connection) {
        //静态方法  释放连接 (关闭连接)  参数 ResultSet  Statemnet Connection
        if (resultSet != null) {
            try {
                resultSet.close();
                //如果resultSet不为空 关闭resultSet
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
            //有异常 的时候

        }
        if (stmt != null) {
            try {
                stmt.close();
                //如果stmt 不为空 关闭stmt
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
            //有异常 的时候
        }
        if (connection != null) {
            try {
                connection.close();
                //如果connection不为空 关闭connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
            //有异常 的时候
        }
    }

}
