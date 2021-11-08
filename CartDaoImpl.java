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
    public List<Book> listBooks(Users user) throws SQLException {
        List<Book> Books = new ArrayList<>();
        BookDao bdao = DaoFactory.getBookDao();
        String sql = "select book_id from cart where user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
           Books.add(bdao.getById(resultSet.getInt(1)));
        }
        return Books;
    }

    @Override
    // add books to the cart
    public void addBook(Book book, Users user) throws SQLException {
        String sql = "insert into cart (book_id, user_id) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, book.getId());
        preparedStatement.setInt(2, user.getId());
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
    public void removeBook(int id,Users user,Cart cart) throws SQLException {
        String sql = "delete from cart where user_id = ? and book_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setInt(2, id);
        int count = preparedStatement.executeUpdate();
        if (count == 1){
            System.out.println("Book has been removed from cart.");
            System.out.println(" ");
            BookDao bDao = DaoFactory.getBookDao();
            Book book = bDao.getById(id);
            cart.removeBook(book);    
        }
        
        else
            System.out.println("Error");
    }

	@Override
	public void clearBooks(Users user, Cart cart) throws SQLException {
        String sql = "delete from cart where user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        try {
        preparedStatement.executeUpdate();    
        cart.clear();    
        }
        
        
        catch(Exception E){
            System.out.println("Error, please contact manager");
        }	
	}
}
