package study.ssm.controller;

import study.ssm.dao.impl.BookDAOImpl;
import study.ssm.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        BookServiceImpl bookService = new BookServiceImpl();
        String bid = req.getParameter("bid");
        String username = (String) req.getSession().getAttribute("username");
        if(bid != null && username != null && username.equals("admin")){
            if(bookService.deleteBook(Integer.parseInt(bid))) {
                resp.sendRedirect("index.jsp");
            }
        }
        resp.getWriter().print("<h2>删除失败,内容出错或者你没有权限!</h2><br>");
        resp.getWriter().print("<a href='index.jsp'>点击返回主页</a>");

    }
}
