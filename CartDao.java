package com.company;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    public void checkOut() throws SQLException;
    public void addBook(Book book, Users user) throws SQLException;
    // remove book from the cart by id
    public void removeBook(int id,Users user,Cart cart) throws SQLException;
    public void clearBooks(Users user,Cart cart) throws SQLException;
	List<Book> listBooks(Users user) throws SQLException;
}
