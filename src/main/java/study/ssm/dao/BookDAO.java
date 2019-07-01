package study.ssm.dao;

import study.ssm.entity.Book;

import java.util.List;

public interface BookDAO {

    public int insertNewBook(Book book);
    public int deleteSavedBook(int bid);
    public List<Book> getAllBooks();

}
