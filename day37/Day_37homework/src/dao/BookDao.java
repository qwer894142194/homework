package dao;

import domain.Book;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();

    public void insertBook(Book book){
        String sql  = "insert into book values(?,?,?,?)";
        Connection conn= null;
        try {
              conn = JdbcUtil.getConnection();
            qr.update(conn,sql,book.getBookName(),book.getAuthor(),book.getPrice(),book.getCategory());
            JdbcUtil.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(conn);
        }
    }

    public  void queryFromByBook(Book book, String sql){
        Connection conn =JdbcUtil.getConnection();
       // qr.query(conn,sql,book);
    }

    public  List<Book> queryAllBook(String sql){


            Connection conn = null;
        try {
               conn = JdbcUtil.getConnection();
              List<Book> books =  qr.query(conn,sql,new BeanListHandler<Book>(Book.class));
          return  books;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn !=null){
                JdbcUtil.close(conn);
            }
        }
    }
    public  List<Book> queryAllBook1(String sql){


        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            List<Book> books =  qr.query(conn,sql,new BeanListHandler<Book>(Book.class));
            return  books;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn !=null){
                JdbcUtil.close(conn);
            }
        }
    }
}
