package com.company;

import java.sql.*;
import java.util.List;

public class CartDaoImpl implements CartDao{
    Connection connection;
    public CartDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void checkOut() throws SQLException {

    }

    @Override
    public List<Book> listBooks() throws SQLException {
        return null;
    }

    @Override
    public void addBook(Book book) throws SQLException {

    }

    @Override
    public void removeBook(Book book) throws SQLException {

    }
}
