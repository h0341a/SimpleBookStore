<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>主页</title>
    <style type="text/css">
        table,th,td
        {
            border:1px solid;
        }
    </style>
</head>
<body>
    <div style="margin: auto; width: 60%;">
        <div style="float: right;">
            ${actionState}
            <br>
            <%
                String username = (String) session.getAttribute("username");
                if(username != null){
                    out.print("welcome," + username + "<a href='"+ request.getContextPath() +"/user/logout'>注销</a>");
                }else{
            %>
            <form action="${pageContext.request.contextPath}/user/login" method="post">
                <label>
                    用户名：
                    <input type="text" name="username">
                </label>
                <label>
                    密码:
                    <input type="password" name="password">
                </label>
                <input type="submit" value="登录">
            </form>
            <%
                }
            %>
        </div>
        <br>
        <br>
        <br>
        <br>

        <div style="text-align: center">
            <table style="text-align: center; margin: auto;">
            <%
                if(username != null){
                    out.print("<tr> <form action='"+request.getContextPath()+"/book/insert' method='GET'>" +
                            "<td>添加书籍</td>" +
                            "<td><input type='text' name='bookName' placeholder='书名'></td>" +
                            "<td><input type='text' name='writer' placeholder='作者'></td>" +
                            "<td><input type='submit' value='提 交'></td>" +
                            "</form></tr>");
                }
            %>
                <tr><td>id</td><td>name</td><td>writer</td><td>op</td></tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.getBid()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getWriter()}</td>
                        <td><a href='${pageContext.request.contextPath}/book/delete?bid=${book.getBid()}'>删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
