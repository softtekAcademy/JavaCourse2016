package com.softtek.java.academy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerDatabase {

    static {

        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private DriverManagerDatabase() {

    }

    public static Connection getConnection() {

        Connection connection = null;
        try {

            connection =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/omsdb", "omsdb", "omsdb");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
