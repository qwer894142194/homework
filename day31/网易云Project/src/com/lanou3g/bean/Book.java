package com.lanou3g.bean;

public class Book {
    private int id;

    public Book(int id, String bookName, String bookPrice, String bookWriter) {
        this.id = id;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookWriter = bookWriter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String bookName;
    private String bookPrice;
    private String bookWriter;

    public Book(String bookName, String bookPrice, String bookWriter) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookWriter = bookWriter;
    }

  public Book(){

  }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }
}
