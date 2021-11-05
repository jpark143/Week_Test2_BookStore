package com.company;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    public void checkOut() throws SQLException;
    public List<Cart> listBooks() throws SQLException;
    public void addBook(Book book, Users users) throws SQLException;
    // remove book from the cart by id
    public void removeBook(int id) throws SQLException;
}
