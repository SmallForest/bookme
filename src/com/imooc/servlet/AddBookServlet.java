package com.imooc.servlet;

import com.imooc.yangsen.Book;
import com.imooc.yangsen.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有分类并赋值给cate
        List l = new LibServiceImpl().getAllBookCatgory();
        if(l.size() == 0){
            request.setAttribute("msg", "请先添加分类！");
            request.getRequestDispatcher("/addBook.jsp").forward(request, response);
            return;
        }
        request.setAttribute("cate", l);
        request.getRequestDispatcher("/addBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String bookName = request.getParameter("bookName");
        String catgoryName = request.getParameter("catgoryName");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        // 数据合法性判断
        LibServiceImpl lsi = new LibServiceImpl();
        //id重复判断
        if(lsi.isBookExist(Integer.parseInt(id))){
            request.setAttribute("msg", "书籍已存在！");
            request.getRequestDispatcher("/addBook.jsp").forward(request, response);
            return;
        }
        //插入数据
        lsi.addBook(new Book(Integer.parseInt(id), bookName, catgoryName, Double.parseDouble(price), description));
        request.setAttribute("msg", "书籍添加成功！");
        request.getRequestDispatcher("/addBook.jsp").forward(request, response);
    }
}
