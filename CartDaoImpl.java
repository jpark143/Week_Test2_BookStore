package com.company;

import java.sql.*;
import java.util.ArrayList;
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
    // to get list of books in the cart
    public List<Cart> listBooks() throws SQLException {
        List<Cart> carts = new ArrayList<>();
        String sql = "select * from cart";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            int bookId = resultSet.getInt(2);
            int userId = resultSet.getInt(3);
            String title = resultSet.getNString(4);
            double price = resultSet.getDouble(5);
            Cart cart = new Cart();
            carts.add(cart);
        }
        return carts;
    }

    @Override
    // add books to the cart
    public void addBook(Book book, Users users) throws SQLException {
        String sql = "insert into cart (book_id title user_id) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, book.getId());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setInt(3, users.getId());
        int count = preparedStatement.executeUpdate();
        if (count > 0){
            System.out.println("Book has been added to your cart!");
            System.out.println(" ");
        }
        else
            System.out.println("Error");

    }

    @Override
    // remove books from the cart
    public void removeBook(int id) throws SQLException {
        String sql = "delete from cart where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count == 1){
            System.out.println("Book has been removed from cart.");
            System.out.println(" ");
        }
        else
            System.out.println("Error");

    }
}
