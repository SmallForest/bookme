package com.imooc.servlet;

import com.google.code.kaptcha.Constants;
import com.imooc.yangsen.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        //获取session中的验证码和code对比
        String s_code = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (code != null && s_code != null) {
            if (!code.equalsIgnoreCase(s_code)) {
                req.setAttribute("msg", "验证码错误");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                return;
            }
        } else {
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        //执行登录
        LibServiceImpl lsi = new LibServiceImpl();
        if (lsi.isUserExist(username)) {
            //检查是否注册，已经注册核查密码是否正确
            if (lsi.login(username, password)) {
                //登录成功
                req.getSession().setAttribute("username", username);
                req.setAttribute("username", username);
                req.getRequestDispatcher("/server.jsp").forward(req, resp);
                return;
            } else {
                req.setAttribute("msg", "用户名或者密码错误");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                return;
            }
        } else {
            //未注册，去注册页面
            req.getRequestDispatcher("/register.jsp?s=1").forward(req, resp);
            return;
        }
    }
}
