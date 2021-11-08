package com.company;

import java.sql.SQLException;
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

    public void removeBook(Book book) {
    	books.remove(book);
    }
    
    public List<Book> getList() {
        return this.books;
    }

    public void clear() {
        books.clear();
        System.out.println("Your cart has been cleared\n");
    }
    
    public void initialize(Users user) throws SQLException {
    	CartDao cdao = DaoFactory.getCartDao();
    	books = cdao.listBooks(user);
    }
}
