package com.company;

public class Cart {
    int item;
    int bookId;
    int userId;
    String title;
    double price;

    // maybe cart needs to store book name and price as well?

    public Cart(){

    }

    public Cart(int item, String title, int bookId, int userId, double price){
        this.item = item;
        this.title = title;
        this.bookId = bookId;
        this.userId = userId;
        this.price =price;

    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
