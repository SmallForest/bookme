package com.imooc.servlet;

import com.imooc.yangsen.LibServiceImpl;
import com.imooc.yangsen.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkPWD = req.getParameter("checkPWD");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        //检查用户名是否合法
        LibServiceImpl lsi = new LibServiceImpl();
        if (username.equals("")) {
            req.setAttribute("msg", "用户名非法！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        if (lsi.isUserExist(username)) {
            req.setAttribute("msg", "用户名已存在！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        //检查密码一致性
        if (!password.equals(checkPWD)) {
            req.setAttribute("msg", "用户名非法或者已存在！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        //执行注册
        lsi.regist(new User(username, password, phone, email));
        //注册成功跳转到图书管理首页！
        req.getSession().setAttribute("username", username);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        return;
    }
}
