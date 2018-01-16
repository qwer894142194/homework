package domain;

public class Book {
    private String bookName;
    private String author;
    private int price;
    private String category;

    public Book() {
    }

    public String getBookName() {

        return bookName;
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public Book(String author, int price, String category, String name) {

            this.bookName = name;

        this.author = author;
        this.price = price;
        this.category = category;
    }
}
