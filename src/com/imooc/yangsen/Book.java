package com.imooc.yangsen;

public class Book {
    protected int id;//索引ID
    protected String name;//书名
    protected String cate_name;//分类名称
    protected double price;//价格
    protected String desc;//描述

    public Book() {
    }

    public Book(int id, String name, String cate_name, double price, String desc) {
        this.id = id;
        this.name = name;
        this.cate_name = cate_name;
        this.price = price;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cate_name='" + cate_name + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
