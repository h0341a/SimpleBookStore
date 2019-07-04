package study.ssm.dao.impl;

import study.ssm.dao.BookDAO;
import study.ssm.entity.Book;
import study.ssm.utils.MySqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public int insertNewBook(Book book) {
        try {
            MySqlSessionFactory.getSqlSession();
            BookDAO bookDAO = MySqlSessionFactory.session.getMapper(BookDAO.class);
            int state = bookDAO.insertNewBook(book);
            MySqlSessionFactory.session.commit();
            return state;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteSavedBook(int bid) {
        try {
            MySqlSessionFactory.getSqlSession();
            BookDAO bookDAO = MySqlSessionFactory.session.getMapper(BookDAO.class);
            int state = bookDAO.deleteSavedBook(bid);
            MySqlSessionFactory.session.commit();
            return state;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> getAllBooks() {
        try {
            MySqlSessionFactory.getSqlSession();
            BookDAO bookDAO = MySqlSessionFactory.session.getMapper(BookDAO.class);
            return bookDAO.getAllBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
