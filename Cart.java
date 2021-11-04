package com.company;

public class Cart {
    int item;
    int bookId;
    int userId;

    public Cart(){

    }

    public Cart(int item, int bookId, int userId){
        this.item = item;
        this.bookId = bookId;
        this.userId = userId;

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
}
