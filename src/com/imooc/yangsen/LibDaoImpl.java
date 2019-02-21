package com.imooc.yangsen;

import java.util.*;

public class LibDaoImpl {
    private static final List<User>                userDb = new ArrayList<>();
    private static final List<Map<String, Object>> cate   = new ArrayList<>();
    private static final List<Book>                books  = new ArrayList<>();

    /**
     * 注册
     *
     * @param user
     */
    public void regist(User user) {
        userDb.add(user);
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        Iterator it = userDb.iterator();
        while (it.hasNext()) {
            User user = (User) it.next();
            if (user.name.equals(username) && user.pwd.equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断用户是是否注册
     *
     * @param username
     * @return boolean
     */
    public Boolean isUserExist(String username) {
        Iterator it = userDb.iterator();
        while (it.hasNext()) {
            User user = (User) it.next();
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }


    public void addBookCatgory(Long id, String catgoryName, String description) {
        HashMap hm = new HashMap();
        hm.put("id", id);
        hm.put("catgoryName", catgoryName);
        hm.put("description", description);
        cate.add(hm);
    }

    public List<Map<String, Object>> getAllBookCatgory() {
        return cate;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName) {
        List b = books;
        List new_b = new ArrayList();
        if (bookID.equals("")){
            bookID = "0";
        }
        Iterator it = b.iterator();
        while (it.hasNext()){
            Book book = (Book) it.next();
            if (book.id == Integer.parseInt(bookID) || book.name.equals(bookName) || book.cate_name.equals(catgoryName)){
                new_b.add(book);
            }
        }
        if(new_b.size()>0){
            return new_b;
        }
        return b;
    }

    /**
     * 检查分类是否存在
     *
     * @param id
     * @return
     */
    public boolean isCateExist(Long id) {
        //创建迭代器
        Iterator it = cate.iterator();
        //执行迭代 判断ID
        while (it.hasNext()) {
            HashMap hm = (HashMap) it.next();
            if (hm.get("id") == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isBookExist(int id) {
        //创建迭代器
        Iterator it = books.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            if (book.id == id) {
                return true;
            }

        }
        return false;
    }
}
