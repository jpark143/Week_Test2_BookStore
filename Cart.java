package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Book> books = new ArrayList<Book>();

    // maybe cart needs to store book name and price as well?

    public Cart(){

    }

    public Cart(Book book){
        addBook(book);

    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("\n"+book.getTitle()+" has been added to your cart\n");
    }

    public List<Book> getList() {
        return this.books;
    }

    public void clear() {
        books.clear();
        System.out.println("Your cart has been cleared\n");
    }
}
