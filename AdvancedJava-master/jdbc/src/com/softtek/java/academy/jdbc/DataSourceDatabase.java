package com.softtek.java.academy.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceDatabase {

    private static BasicDataSource ds;

    static {
        //Data sources are provided and configured normally in Application servers
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("omsdb");
        ds.setPassword("omsdb");
        ds.setUrl("jdbc:mysql://localhost:3306/omsdb?noAccessToProcedureBodies=true");
    }

    private DataSourceDatabase() {

    }

    public static Connection getConnection() {

        Connection connection = null;
        
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
