package com.bookstore.model;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "Sneh@sure2005"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
