package com.lanou3g.dao;

import com.lanou3g.main.Book;
import com.lanou3g.main.User;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr  = new QueryRunner();

        public void insert(Book book){
            Connection conn = JdbcUtil.getConnection();
            String sql = "insert into book values (null,?,?,?)";

            try {
                qr.update(conn,sql,book.getBookName(),book.getBookPrice(),book.getBookWriter());
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public List<Book> queryAll(){
            String sql = "select * from  book";
            Connection conn = null;
            conn= JdbcUtil.getConnection();

            try {
                List<Book> book = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
                return  book;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                JdbcUtil.close(conn);
            }
            return null;
        }





}
