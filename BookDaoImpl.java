package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
    Connection connection;
    public BookDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "select * from book";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String title = resultSet.getNString(2);
            String author = resultSet.getNString(3);
            String isbn = resultSet.getNString(4);
            double price = resultSet.getDouble(5);
            String category = resultSet.getNString(6);
            String description = resultSet.getNString(7);
            Book book = new Book(id, title, author, isbn, price, category, description);
            books.add(book);
        }
        return books;
    }

    @Override
    public Book getById(int id) throws SQLException {
        Book book = new Book();
        String sql = "select * from book where id = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if (resultSet != null){
            int bookId = resultSet.getInt(1);
            String title = resultSet.getNString(2);
            String author = resultSet.getNString(3);
            String isbn = resultSet.getNString(4);
            double price = resultSet.getDouble(5);
            String category = resultSet.getNString(6);
            String description = resultSet.getNString(7);
            book = new Book(bookId, title, author, isbn, price, category, description);
        }
        else
            System.out.println("Error");
        return book;

    }

    @Override
    public Category getByCategory(int id) throws SQLException {
        Category category = new Category();
        String sql = "select * from category where id = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if (resultSet != null){
            id = resultSet.getInt(1);
            String categoryName = resultSet.getNString(2);
            category = new Category(id, categoryName);
        }
        else
            System.out.println("Error");
        return category;
    }
}
