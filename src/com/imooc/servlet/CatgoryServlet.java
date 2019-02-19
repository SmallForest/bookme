package com.imooc.servlet;

import com.imooc.yangsen.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/CatgoryServlet")
public class CatgoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String catgoryName = request.getParameter("catgoryName");
        String description = request.getParameter("description");
        if (id.equals("") || catgoryName.equals("") || description.equals("")) {
            request.setAttribute("msg", "请填写完整！");
            request.getRequestDispatcher("/catgory.jsp").forward(request, response);
            return;
        }
        //判断分类是否存在
        if(new LibServiceImpl().isCateExist(Long.parseLong(id))){
            request.setAttribute("msg", "该分类已经存在！");
            request.getRequestDispatcher("/catgory.jsp").forward(request, response);
            return;
        }

        //添加
        new LibServiceImpl().addBookCatgory(Long.parseLong(id), catgoryName, description);
        request.setAttribute("msg", "添加成功！");
        request.getRequestDispatcher("/catgory.jsp").forward(request, response);
        return;
    }
}
