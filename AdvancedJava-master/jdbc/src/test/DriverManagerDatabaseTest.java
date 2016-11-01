package test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.softtek.java.academy.jdbc.DriverManagerDatabase;

public class DriverManagerDatabaseTest {

    @Test
    public void shouldConnectViaDriverManager() {

        try {
            Connection connection = DriverManagerDatabase.getConnection();

            assertNotNull(connection);

            System.out.println(connection.getMetaData()
                .getDatabaseProductName());
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
