package com.softtek.java.academy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.java.academy.jdbc.entity.OrderStatus;
import com.softtek.java.academy.jdbc.entity.SalesChannel;
import com.softtek.java.academy.jdbc.entity.SalesOrder;

public class OrderViewRepository {

    public SalesOrder selectOrderByID(String id) {

        SalesOrder salesOrder = new SalesOrder();
        Connection connection = DataSourceDatabase.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT so.order_id, so.status_code, ss.description, "
            + "so.channel_code, sc.description, ");
        sql.append("so.date_created FROM sales_order so JOIN order_status ss ON");
        sql.append(" so.status_code = ss.status_code JOIN sales_channel sc ON ");
        sql.append("so.channel_code = sc.channel_code ");
        sql.append("WHERE so.order_id = ?");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                salesOrder.setId(resultSet.getString(1));
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setCode(resultSet.getString(2));
                orderStatus.setDescription(resultSet.getString(3));

                salesOrder.setOrderStatus(orderStatus);

                SalesChannel salesChannel = new SalesChannel();
                salesChannel.setCode(resultSet.getString(4));
                salesChannel.setDescription(resultSet.getString(5));

                salesOrder.setSalesChannel(salesChannel);
                salesOrder.setCreationDate(resultSet.getDate(6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            this.close(resultSet, preparedStatement, connection);
        }

        return salesOrder;
    }

    public List<SalesOrder> selectOrdersByChannel(String channel) {

        List<SalesOrder> orders = new ArrayList<SalesOrder>();
        SalesOrder salesOrder = new SalesOrder();
        Connection connection = DataSourceDatabase.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT so.order_id, so.status_code, ss.description, "
            + "so.channel_code, sc.description, ");
        sql.append("so.date_created FROM sales_order so JOIN order_status ss ON");
        sql.append(" so.status_code = ss.status_code JOIN sales_channel sc ON ");
        sql.append("so.channel_code = sc.channel_code ");
        sql.append("WHERE so.channel_code = ?");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, channel);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                salesOrder.setId(resultSet.getString(1));
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setCode(resultSet.getString(2));
                orderStatus.setDescription(resultSet.getString(3));

                salesOrder.setOrderStatus(orderStatus);

                SalesChannel salesChannel = new SalesChannel();
                salesChannel.setCode(resultSet.getString(4));
                salesChannel.setDescription(resultSet.getString(5));

                salesOrder.setSalesChannel(salesChannel);
                salesOrder.setCreationDate(resultSet.getDate(6));
                orders.add(salesOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            this.close(resultSet, preparedStatement, connection);
        }

        return orders;
    }

    public List<SalesOrder> selectOrdersByStatus(String status) {

        List<SalesOrder> orders = new ArrayList<SalesOrder>();
        SalesOrder salesOrder = new SalesOrder();
        Connection connection = DataSourceDatabase.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT so.order_id, so.status_code, ss.description, "
            + "so.channel_code, sc.description, ");
        sql.append("so.date_created FROM sales_order so JOIN order_status ss ON");
        sql.append(" so.status_code = ss.status_code JOIN sales_channel sc ON ");
        sql.append("so.channel_code = sc.channel_code ");
        sql.append("WHERE so.status_code = ?");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, status);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                salesOrder.setId(resultSet.getString(1));
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setCode(resultSet.getString(2));
                orderStatus.setDescription(resultSet.getString(3));

                salesOrder.setOrderStatus(orderStatus);

                SalesChannel salesChannel = new SalesChannel();
                salesChannel.setCode(resultSet.getString(4));
                salesChannel.setDescription(resultSet.getString(5));

                salesOrder.setSalesChannel(salesChannel);
                salesOrder.setCreationDate(resultSet.getDate(6));
                orders.add(salesOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            this.close(resultSet, preparedStatement, connection);
        }

        return orders;
    }

    private void close(ResultSet resultSet,
        PreparedStatement preparedStatement,
        Connection connection) {

        if (resultSet != null && preparedStatement != null
            && connection != null) {

            try {
                if (!resultSet.isClosed()) {
                    resultSet.close();
                }

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
