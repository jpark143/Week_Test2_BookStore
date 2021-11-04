package com.company;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    public void checkOut() throws SQLException;
    public List<Book> listBooks() throws SQLException;
    public void addBook(Book book) throws SQLException;
    public void removeBook(Book book) throws SQLException;
}
