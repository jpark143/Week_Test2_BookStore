package com.company;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    public List<Book> getAllBooks() throws SQLException;
    public Book getById(int id) throws SQLException;
    public List<Category> getAllCategory() throws SQLException;
    public Book getByCategory(int id) throws SQLException;
}
