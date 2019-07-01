package study.ssm.entity;

public class Book {
    private int bid;
    private String bookName;
    private String writer;

    public Book() { }

    public Book(int bid, String bookName, String writer) {
        this.bid = bid;
        this.bookName = bookName;
        this.writer = writer;
    }

    public Book(String bookName, String writer) {
        this.bookName = bookName;
        this.writer = writer;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bookName='" + bookName + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
