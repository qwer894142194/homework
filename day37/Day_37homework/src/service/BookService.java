package service;

import dao.BookDao;
import domain.Book;
import org.junit.Test;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();
    public List<Book> findAll(String sql){
        List<Book> books = bookDao.queryAllBook(sql);
        return books;
    }

    public List<Book> findAll1(String sql){
        List<Book> books = bookDao.queryAllBook(sql);
        return books;
    }
}
