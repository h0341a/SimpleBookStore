package study.ssm.service;

import study.ssm.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getBookList();
    public boolean deleteBook(int bid);
    public boolean insertBook(Book book);

}
