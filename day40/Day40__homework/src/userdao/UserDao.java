package userdao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = new QueryRunner();

    public  void insert(User user){
        String sql = "insert into user values(?,?,?,?)";
        Connection conn  = C3P0Util.getConnection();
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhoneNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.release(null,null,conn);
        }

    }
    public  User queryByUserName(User user){
                String sql = "select * from user";
                Connection conn = C3P0Util.getConnection();
        try {
            User userD = qr.query(conn, sql, new BeanHandler<User>(User.class), user.getUsername());
            return userD;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
             C3P0Util.release(null,null,conn);
        }
    }


}
