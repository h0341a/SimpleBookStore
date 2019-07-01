package study.ssm.dao.impl;

import study.ssm.dao.BookDAO;
import study.ssm.entity.Book;
import study.ssm.utils.ConnMariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public int insertNewBook(Book book) {
        String sql = "INSERT INTO book(book_name, writer) values( ?, ?)";
        ConnMariaDB.connInit();
        try {
            PreparedStatement ps = ConnMariaDB.connection.prepareStatement(sql);
            ps.setObject(1, book.getBookName());
            ps.setObject(2, book.getWriter());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("插入书籍信息出错!");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteSavedBook(int bid) {
        String sql = "DELETE FROM book WHERE bid = ?";
        ConnMariaDB.connInit();
        try {
            PreparedStatement ps = ConnMariaDB.connection.prepareStatement(sql);
            ps.setObject(1, bid);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("删除书籍信息出错!");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        ConnMariaDB.connInit();
        try {
            PreparedStatement ps = ConnMariaDB.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Book> books = new ArrayList<>();
            while (rs.next()){
                int bid = rs.getInt("bid");
                String bookName = rs.getString("book_name");
                String writer = rs.getString("writer");
                Book book = new Book(bid, bookName, writer);
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            System.err.println("获取所有书籍信息出错!");
            e.printStackTrace();
        }
        return null;
    }
}
