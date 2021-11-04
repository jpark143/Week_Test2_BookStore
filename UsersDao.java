package com.company;

import java.sql.SQLException;

public class UsersDao {
    public boolean login(String username, String password) throws SQLException;
    public void menu() throws SQLException;
}
