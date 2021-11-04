package com.company;

import java.sql.SQLException;

public class DaoFactory {
    private static BookDao bDao;
    private static UsersDao uDao;
    private static CartDao cDao;

    public static BookDao getBookDao() throws SQLException {
        if (bDao ==null) {
            bDao = new BookDaoImpl();
        }
        return bDao;
    }
    public static UsersDao getUsersDao() throws SQLException {
        if (uDao ==null) {
            uDao = new UsersDaoImpl();
        }
        return uDao;
    }
    public static CartDao getCartDao() throws SQLException {
        if (cDao ==null) {
            cDao = new CartDaoImpl();
        }
        return cDao;
    }

}
