package com.company;

import java.sql.SQLException;

public interface UsersDao {
    public boolean login(String username, String password) throws SQLException;
    public void menu() throws SQLException;
    public boolean createUser(String username, String password) throws SQLException;
    public Users getUser(String name) throws SQLException;
    public boolean checkUser(String name) throws SQLException;
}
