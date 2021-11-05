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
    
    @Override
    public void menu() throws SQLException {

    }
}
