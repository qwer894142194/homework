package domain;

import java.util.List;

public class PageBean {
        private List<Book> books;
        private int pageCode;
        private int totalData;
        private int pageSize= 10 ;

        private String params;



    public PageBean() {
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "books=" + books +
                ", pageCode=" + pageCode +
                ", totalData=" + totalData +
                ", pageSize=" + pageSize +
                ", params='" + params + '\'' +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public PageBean(List<Book> books, int pageCode, int totalData, int pageSize, String params) {

        this.books = books;
        this.pageCode = pageCode;
        this.totalData = totalData;
        this.pageSize = pageSize;
        this.params = params;
    }

    public int getTotalPages() {

        int ps = totalData / 10 ;
        if (totalData % 10 > 0){
            ps++;
        }
        return ps;
    }
}
