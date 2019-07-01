package study.ssm.controller;

import study.ssm.entity.Book;
import study.ssm.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insertBook")
public class InsertBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookServiceImpl bookService = new BookServiceImpl();
        String bookName = req.getParameter("bookname");
        String writer = req.getParameter("writer");
        String username = (String) req.getSession().getAttribute("username");
        if(username != null && bookName != null && writer != null) {
            Book book = new Book(bookName, writer);
            if(bookService.insertBook(book)) {
                resp.sendRedirect("index.jsp");
            }
        }
        resp.getWriter().print("<h2>删除失败,内容出错或者你没有权限!</h2><br>");
        resp.getWriter().print("<a href='index.jsp'>点击返回主页</a>");
    }
}
