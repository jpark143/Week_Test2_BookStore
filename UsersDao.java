package com.company;

import java.sql.SQLException;

public interface UsersDao {
    // need add user??
    public boolean login(String username, String password) throws SQLException;
    public void menu() throws SQLException;
	public boolean createUser(String username, String password) throws SQLException;
	public boolean checkUser(String name) throws SQLException;
}
