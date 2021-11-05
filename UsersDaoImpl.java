package com.company;

import java.sql.*;

public class UsersDaoImpl implements UsersDao{
    Connection connection;
    public UsersDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public boolean login(String username, String password) throws SQLException {
        return false;
    }

    @Override
    public void menu() throws SQLException {

    }
}
