package study.ssm.service.impl;

import study.ssm.dao.BookDAO;
import study.ssm.dao.impl.BookDAOImpl;
import study.ssm.entity.Book;
import study.ssm.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAOImpl bookDAO = new BookDAOImpl();

    @Override
    public List<Book> getBookList() {
        return bookDAO.getAllBooks();
    }

    @Override
    public boolean deleteBook(int bid) {
        return bookDAO.deleteSavedBook(bid) != 0;
    }

    @Override
    public boolean insertBook(Book book) {
        return bookDAO.insertNewBook(book) != 0;
    }
}
