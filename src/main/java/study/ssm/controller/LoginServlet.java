package study.ssm.controller;

import study.ssm.entity.User;
import study.ssm.service.UserService;
import study.ssm.service.impl.UserServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        UserServiceImpl userService = new UserServiceImpl();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        if(userService.checkUser(user)){
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("index.jsp");
        }else{
            resp.getWriter().print("<h2>登录失败,请重试</h2><br>");
            resp.getWriter().print("<a href='index.jsp'>点击返回主页</a>");
        }
    }

}
