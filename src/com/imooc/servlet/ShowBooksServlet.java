package com.imooc.servlet;

import com.alibaba.fastjson.JSON;
import com.imooc.yangsen.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowBooksServlet")
public class ShowBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", new LibServiceImpl().getBooksByCondition("", "", ""));
        request.getRequestDispatcher("/showBooks.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookID = request.getParameter("bookID");
        String bookName = request.getParameter("bookName");
        String catgoryName = request.getParameter("catgoryName");
        List l = new LibServiceImpl().getBooksByCondition(bookID, bookName, catgoryName);
        String s = JSON.toJSONString(l);
        // content type 不然就会乱码
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(s);
    }
}
