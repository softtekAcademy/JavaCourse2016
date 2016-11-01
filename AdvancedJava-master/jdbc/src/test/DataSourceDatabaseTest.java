package test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.softtek.java.academy.jdbc.DataSourceDatabase;

public class DataSourceDatabaseTest {

    @Test
    public void shouldConnectViaDataSource() {

        try {
            Connection connection = DataSourceDatabase.getConnection();

            assertNotNull(connection);

            System.out.println(connection.getMetaData()
                .getDatabaseProductName());
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
