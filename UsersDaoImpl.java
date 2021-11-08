package com.company;

import java.sql.*;

public class UsersDaoImpl implements UsersDao{
    Connection connection;
    public UsersDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }


    //procedure used
    public boolean login(String name, String password) throws SQLException {
        String sql = "select * from users where username= ? and password =?";
        //String sql = "Call userPassword(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
    //procedure used
    public boolean checkUser(String name) throws SQLException {
        String sql = "select * from users where username= ?";
        //String sql = "Call userPassword(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public Users getUser(String name) throws SQLException {
        String sql = "select id from users where username= ?";
        //String sql = "Call userPassword(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flag = resultSet.next();
        Users user = new Users();
        if(flag) {
        user.setId( resultSet.getInt(1));
        user.setUserName(name);
        }
        return user;
    }
    
    @Override
    public void menu() throws SQLException {

    }
    @Override
    public boolean createUser(String username, String password) throws SQLException {
        String sql = "insert into users(username,password) values (?,?);";
        //String sql = "Call userPassword(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        int resultSet = preparedStatement.executeUpdate();
        return resultSet>0;

    }
}
