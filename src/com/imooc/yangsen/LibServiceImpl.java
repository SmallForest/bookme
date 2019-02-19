package com.imooc.yangsen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibServiceImpl {
    LibDaoImpl libDao = new LibDaoImpl();

    public void regist(User user) {
        libDao.regist(user);
    }

    public boolean login(String username, String password) {
        return libDao.login(username, password);
    }

    public boolean isUserExist(String username) {
        return libDao.isUserExist(username);
    }

    public void addBookCatgory(Long id, String catgoryName, String description) {
        libDao.addBookCatgory(id, catgoryName, description);
    }

    public List<Map<String, Object>> getAllBookCatgory() {
        return libDao.getAllBookCatgory();
    }

    public void addBook(Book book) {
        libDao.addBook(book);
    }

    public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName) {
        return libDao.getBooksByCondition(bookID, bookName, catgoryName);
    }

    public boolean isCateExist(Long id) {
        return libDao.isCateExist(id);
    }

    public boolean isBookExist(int id) {
        return libDao.isBookExist(id);
    }
}
