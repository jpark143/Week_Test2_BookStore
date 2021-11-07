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
        String sql = "select a.id, a.title,a.author,a.ISBN,a.price,b.category,a.description from book a join category b on a.category = b.id;";
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
//      String sql = "select * from book where id = " + id;
        String sql = "select a.id, a.title,a.author,a.ISBN,a.price,b.category,a.description from book a join category b on a.category = b.id where a.id =?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

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
    public List<Category> getAllCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from category";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String category = resultSet.getNString(2);
            Category category1 = new Category(id, category);
            categories.add(category1);
        }
        return categories;
    }

    @Override
    public Book getByCategory(int id) throws SQLException {
        Book book = new Book();
        String sql = "select * from book where category = " + id;
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
}
