package com.softtek.academy.jstl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jstl.connection.DriverManagerDatabase;
import com.softtek.academy.jstl.domain.model.Cart;
import com.softtek.academy.jstl.domain.model.ShipTo;
import com.softtek.academy.jstl.domain.model.Status;

public class CartRepository {
	
	
	public List<Cart> list() {
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT c.*, st.name ship_to, s.description status");
		sql.append("  FROM cart c");
		sql.append("  JOIN ship_to st ON st.ship_to_id = c.ship_to_id");
		sql.append("  JOIN status s ON s.status_id = c.status_id");

        
        
        final List<Cart> carts = new ArrayList<Cart>();
        
        try (
        		Connection connection = DriverManagerDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        	) {
        	
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
	            carts.add(this.buildCart(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return carts; 
	}
	
	public Cart findOne(final Long cartId) {
        Connection connection = DriverManagerDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        
        Cart cart = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cart WHERE cart_id = ?");
            preparedStatement.setLong(1, cartId);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            rs.next();
            cart = this.buildCart(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return cart;
	}
	
	private Cart buildCart(final ResultSet rs) throws SQLException {
		Cart cart = new Cart();
		
		final int columnCount = rs.getMetaData().getColumnCount();
		
		cart.setId(rs.getLong("cart_id"));
        cart.setLinesAmount(rs.getDouble("lines_amount"));
        cart.setShippingAmount(rs.getDouble("shipping_amount"));
        cart.setCartAmount(rs.getDouble("cart_amount"));
        cart.setShipTo(new ShipTo(rs.getLong("ship_to_id"), columnCount>10 ? rs.getString("ship_to") : ""));
        cart.setStatus(new Status(rs.getLong("status_id"), columnCount>10 ? rs.getString("status") : "",  ""));
        cart.setCreateUser(rs.getString("create_user"));
        cart.setCreateDate(rs.getTimestamp("create_date"));
        cart.setUpdateUser(rs.getString("update_user"));
        cart.setUpdateDate(rs.getTimestamp("update_date"));
        
		return cart;
	}
}