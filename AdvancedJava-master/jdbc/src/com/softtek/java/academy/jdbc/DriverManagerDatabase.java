package com.softtek.java.academy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DriverManagerDatabase {

	static {

		try {

			DriverManager.registerDriver(new Driver());

		}
		catch (SQLException e) {
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

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
