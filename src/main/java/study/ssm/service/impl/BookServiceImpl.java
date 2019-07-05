package study.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.ssm.dao.BookDAO;
import study.ssm.entity.Book;
import study.ssm.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

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
