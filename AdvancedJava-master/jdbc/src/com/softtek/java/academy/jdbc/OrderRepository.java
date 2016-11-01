package com.softtek.java.academy.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.softtek.java.academy.jdbc.entity.SalesOrder;

public class OrderRepository {

    public int updateOrder(SalesOrder order) {

        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE sales_order SET status_code = ? ,"
            + "channel_code = ?");
        sql.append("WHERE order_id = ?");

        Connection connection = DataSourceDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, order.getOrderStatus().getCode());
            preparedStatement.setString(2, order.getSalesChannel().getCode());
            preparedStatement.setString(3, order.getId());

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(preparedStatement, connection);
        }
        return result;
    }

    public void createOrder(SalesOrder order) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO sales_order (order_id, status_code, "
            + "channel_code, date_created ) ");
        sql.append("VALUES (?, ?, ?, ?)");

        Connection connection = DataSourceDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());

            preparedStatement.setString(1, order.getId());
            preparedStatement.setString(2, order.getOrderStatus().getCode());
            preparedStatement.setString(3, order.getSalesChannel().getCode());
            preparedStatement.setDate(4, new Date(order.getCreationDate()
                .getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(preparedStatement, connection);
        }
    }

    public void deleteOrdersByStatus(String status) {

        StringBuilder sql = new StringBuilder();
        sql.append("{call delete_orders(?)}");

        Connection connection = null;
        CallableStatement callableStatement = null;

        try {

            connection = DataSourceDatabase.getConnection();
            callableStatement = connection.prepareCall(sql.toString());
            callableStatement.setString(1, status);
            
            callableStatement.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            this.close(callableStatement, connection);
        }

    }

    private void close(PreparedStatement preparedStatement,
        Connection connection) {

        if (preparedStatement != null && connection != null) {

            try {
                if (!preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
